package br.com.kohen.module.cielo.ws.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.kohen.module.cielo.entity.BusinessEstablishment;
import br.com.kohen.module.cielo.entity.CieloOrder;
import br.com.kohen.module.cielo.entity.CieloPayment;
import br.com.kohen.module.cielo.entity.CieloResponse;
import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.entity.infra.ReadXmlToTest;
import br.com.kohen.module.cielo.enums.CreditCardType;
import br.com.kohen.module.cielo.enums.Currency;
import br.com.kohen.module.cielo.enums.Language;
import br.com.kohen.module.cielo.enums.Modality;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Request.class})
public class CieloWebServiceImplTest {

	private static final String URL = "https://qasecommerce.cielo.com.br/servicos/ecommwsec.do";
	
	@InjectMocks CieloWebServiceImpl service;
	
	@Mock Request requestMock;
	
	@Mock Response responseMock;
	
	@Mock Content contectMock;
	
	@Before
	public void setUp() throws ClientProtocolException, IOException {
		
		given(Request.Post(URL)).willReturn(requestMock);
		given(this.requestMock.connectTimeout(10000)).willReturn(requestMock);
		
		given(this.requestMock.execute()).willReturn(this.responseMock);
		given(this.responseMock.returnContent()).willReturn(this.contectMock);
		
	}
	
	@Test
	public void shouldCallToCreateANewTrasacation() throws IOException, ParseException {
		
		String urlAuthentication = "https://ecommerce.cielo.com.br/web/index.cbmp?id=a783251";
		String tid = "10017348980735271001";
		String templateToSend = ReadXmlToTest.read("/xmlExpected/requisicao-transacao.buypagecielo-template.xml");
		String returnWillBe = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		
		given(this.requestMock.bodyForm(Form.form().add("mensagem", templateToSend).build())).willReturn(requestMock);
		given(this.contectMock.asString()).willReturn(returnWillBe);

		CieloResponse newTransaction = service.newTransaction(getTransactionStub());
		
		CieloTransaction transaction = newTransaction.getTransaction();
		
		assertThat(transaction.getUrlAuthentication(), equalTo(urlAuthentication));
		assertThat(transaction.getTid(), equalTo(tid));
	}
	
	private CieloTransaction getTransactionStub() throws ParseException {
		Calendar calendar = DatatypeConverter.parseDateTime("2013-12-07T11:43:37");

		CieloOrder cieloOrder = CieloOrder.build().withNumber("12345")
			.withAmount(100l)
			.withCurrency(Currency.REAL)
			.withDate(calendar.getTime())
			.withLang(Language.PT);
		
		BusinessEstablishment establishment = BusinessEstablishment.build();
		
		CieloPayment cieloPayment = CieloPayment.build().withCreditCardType(CreditCardType.VISA)
			.withPlots(1)
			.withModality(Modality.DEBIT);
		
		CieloTransaction cieloTransaction = CieloTransaction.build().withOrder(cieloOrder)
			.withBusinessEstablishment(establishment)
			.withPayment(cieloPayment);
		
		return cieloTransaction;
	}
	
}
