package br.com.kohen.module.cielo.ws.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static se.dannej.fakehttpserver.expect.ResponseActions.sendContent;
import static se.dannej.fakehttpserver.expect.ResponseActions.sendStatus;
import static se.dannej.fakehttpserver.expect.matcher.RequestMatchers.content;
import static se.dannej.fakehttpserver.expect.matcher.RequestMatchers.path;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import se.dannej.fakehttpserver.FakeHttpServer;
import se.dannej.fakehttpserver.JettyFakeServer;
import se.dannej.fakehttpserver.expect.Expectations;
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

@RunWith(MockitoJUnitRunner.class)
public class CieloWebServiceImplTest {

	private static final String URL = "https://qasecommerce.cielo.com.br/servicos/ecommwsec.do";
	
	@InjectMocks CieloWebServiceImpl service;
	
	private FakeHttpServer server = new JettyFakeServer(3000);

	@Before
	public void setUp() {
		this.server.start();
	}
	
	@After
	public void tearDown() {
		this.server.stop();
	}
	
	@Test
	public void shouldCallToCreateANewTrasacation() throws IOException, ParseException {
		String urlAuthentication = "https://ecommerce.cielo.com.br/web/index.cbmp?id=a783251";
		String tid = "10017348980735271001";
		
		final String templateToSend = ReadXmlToTest.read("/xmlExpected/requisicao-transacao.buypagecielo-template.xml");
		final String returnWillBe = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		
		new Expectations() {{
			oneOf(CieloWebServiceImplTest.this.server).post().with(
					path(URL),
					content(templateToSend)
					);
			will(
					sendStatus(200),
					sendContent(returnWillBe)
					);
		}};
		
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
