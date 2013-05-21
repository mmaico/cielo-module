package br.com.kohen.module.cielo.ws.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.custommonkey.xmlunit.Diff;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xml.sax.SAXException;

import br.com.kohen.module.cielo.entity.BusinessEstablishment;
import br.com.kohen.module.cielo.entity.CieloOrder;
import br.com.kohen.module.cielo.entity.CieloPayment;
import br.com.kohen.module.cielo.entity.CieloResponse;
import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.entity.infra.ReadXmlToTest;
import br.com.kohen.module.cielo.enums.CieloCreditCardType;
import br.com.kohen.module.cielo.enums.CieloCurrency;
import br.com.kohen.module.cielo.enums.CieloLanguage;
import br.com.kohen.module.cielo.enums.CieloModality;

@SuppressWarnings({ "unchecked"})
@RunWith(PowerMockRunner.class)
@PrepareForTest({Request.class, Form.class})
public class CieloWebServiceImplTest {

	private static final String URL = "https://qasecommerce.cielo.com.br/servicos/ecommwsec.do";
	
	@InjectMocks CieloWebServiceImpl service;
	
	@Mock Request requestMock;
	
	@Mock Response responseMock;
	
	@Mock Content contectMock;
	
	@Captor ArgumentCaptor<List<NameValuePair>> listNameValueCaptor;
	
	@Before
	public void setUp() throws ClientProtocolException, IOException {
		
		mockStatic(Request.class);
		given(Request.Post(URL)).willReturn(requestMock);
		given(this.requestMock.connectTimeout(10000)).willReturn(requestMock);
		
		given(this.requestMock.execute()).willReturn(this.responseMock);
		given(this.responseMock.returnContent()).willReturn(this.contectMock);
		
	}
	
	@Test
	public void shouldCallToCreateANewTrasacation() throws IOException, ParseException {
		
		String urlAuthentication = "https://ecommerce.cielo.com.br/web/index.cbmp?id=a783251";
		String tid = "10017348980735271001";
		String id = "6-e7762cbf8856";
		
		String returnWillBe = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		
		given(this.requestMock.bodyForm(Mockito.anyCollection())).willReturn(requestMock);
		given(this.contectMock.asString()).willReturn(returnWillBe);

		CieloResponse newTransaction = service.newTransaction(getTransactionStub());
		
		CieloTransaction transaction = newTransaction.getTransaction();
		
		assertThat(transaction.getUrlAuthentication(), equalTo(urlAuthentication));
		assertThat(transaction.getTid(), equalTo(tid));
		assertThat(transaction.getId(), equalTo(id));
	}
	
	@Test
	public void shouldVerifyXmlToSend() throws ParseException, SAXException, IOException {
		
		String templateToSendExpected = ReadXmlToTest.read("/xmlExpected/requisicao-transacao.buypagecielo-template.xml");
		String returnWillBe = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		
		given(this.requestMock.bodyForm(Mockito.anyCollection())).willReturn(requestMock);
		given(this.contectMock.asString()).willReturn(returnWillBe);
		
		service.newTransaction(getTransactionStub());
		
		verify(this.requestMock).bodyForm(listNameValueCaptor.capture());
		
		List<NameValuePair> listCaptured = listNameValueCaptor.getValue();
		Diff diff = new Diff(templateToSendExpected, listCaptured.get(0).getValue());
		
		assertThat(listCaptured.get(0).getName(), equalTo("mensagem"));
		assertThat(diff.similar(), Matchers.is(Boolean.TRUE));
	}
	
	@Test
	public void shouldFindATransactionByIdTid() throws IOException, ParseException {
		
		String tid = "10017348980735271001";
		
		String returnWillBe = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		
		given(this.requestMock.bodyForm(Mockito.anyCollection())).willReturn(requestMock);
		given(this.contectMock.asString()).willReturn(returnWillBe);

		CieloResponse response = service.findTransaction(tid, getTransactionStub().getbEstablishment()) ;
		
		CieloTransaction transaction = response.getTransaction();
		
		assertThat(transaction.getTid(), equalTo(tid));
	}
	
	@Test
	public void shouldVerifyXmlToSendToConsult() throws ParseException, SAXException, IOException {
		
		String tid = "10017348980735271001";
		
		String xmlToSend = ReadXmlToTest.read("/xmlExpected/requisicao-consulta-template.xml");
		String willReturn = ReadXmlToTest.read("/xmlReturn/consult-success-buy-cielo-page-return.xml");
		
		given(this.requestMock.bodyForm(Mockito.anyCollection())).willReturn(requestMock);
		given(this.contectMock.asString()).willReturn(willReturn);

		CieloResponse response = service.findTransaction(tid, getTransactionStub().getbEstablishment()) ;
		
		response.getTransaction();
		
		verify(this.requestMock).bodyForm(listNameValueCaptor.capture());
		
		List<NameValuePair> listCaptured = listNameValueCaptor.getValue();
		Diff diff = new Diff(xmlToSend, listCaptured.get(0).getValue());
		
		assertThat(listCaptured.get(0).getName(), equalTo("mensagem"));
		assertThat(diff.similar(), Matchers.is(Boolean.TRUE));
	}
	
	@Test
	public void shouldRenderResponseStatus() throws ParseException, SAXException, IOException {
		
		String tid = "10017348980735271001";
		
		String xmlToSend = ReadXmlToTest.read("/xmlExpected/requisicao-consulta-template.xml");
		String willReturn = ReadXmlToTest.read("/xmlReturn/read-status-return.xml");
		
		given(this.requestMock.bodyForm(Mockito.anyCollection())).willReturn(requestMock);
		given(this.contectMock.asString()).willReturn(willReturn);

		CieloResponse response = service.findTransaction(tid, getTransactionStub().getbEstablishment()) ;
		
		response.getTransaction();
		
		verify(this.requestMock).bodyForm(listNameValueCaptor.capture());
		
		List<NameValuePair> listCaptured = listNameValueCaptor.getValue();
		Diff diff = new Diff(xmlToSend, listCaptured.get(0).getValue());
		
		assertThat(listCaptured.get(0).getName(), equalTo("mensagem"));
		assertThat(diff.similar(), Matchers.is(Boolean.TRUE));
	}
	
	private CieloTransaction getTransactionStub() throws ParseException {
		Calendar calendar = DatatypeConverter.parseDateTime("2013-12-07T11:43:37");

		CieloOrder cieloOrder = CieloOrder.build().withNumber("12345")
			.withAmount(100l)
			.withCurrency(CieloCurrency.REAL)
			.withDate(calendar.getTime())
			.withLang(CieloLanguage.PT);
		
		BusinessEstablishment establishment = BusinessEstablishment.build();
		
		CieloPayment cieloPayment = CieloPayment.build().withCreditCardType(CieloCreditCardType.VISA)
			.withPlots(1)
			.withModality(CieloModality.DEBIT);
		
		CieloTransaction cieloTransaction = CieloTransaction.build().withOrder(cieloOrder)
			.withBusinessEstablishment(establishment)
			.withPayment(cieloPayment);
		
		return cieloTransaction;
	}
	
}
