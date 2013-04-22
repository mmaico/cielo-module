package br.com.kohen.module.cielo.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.entity.infra.ReadXmlToTest;
import br.com.kohen.module.cielo.enums.CieloCurrency;
import br.com.kohen.module.cielo.enums.CieloLanguage;


public class XmlToCieloTransactionTest {

	@Test
	public void shouldConvertXmlToCieloTransation() {
		String urlAuthentication = "https://ecommerce.cielo.com.br/web/index.cbmp?id=a783251";
		
		String xml = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		CieloTransaction transaction = XmlToCieloTransaction.getInstance().create(xml);
		
		assertThat(transaction.getTid(), equalTo("10017348980735271001"));
		assertThat(transaction.getOrder().getNumber(), equalTo("1234"));
		assertThat(transaction.getOrder().getAmount(), equalTo(100l));
		assertThat(transaction.getOrder().getCurrency(), equalTo(CieloCurrency.REAL));
		assertThat(transaction.getOrder().getLang(), equalTo(CieloLanguage.PT));
		assertThat(transaction.getUrlAuthentication(), equalTo(urlAuthentication));
	}
	
	@Test
	public void shouldConvertXmlToCieloResponseError() {
		String urlAuthentication = "https://ecommerce.cielo.com.br/web/index.cbmp?id=a783251";
		
		String xml = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		CieloTransaction transaction = XmlToCieloTransaction.getInstance().create(xml);
		
		assertThat(transaction.getTid(), equalTo("10017348980735271001"));
		assertThat(transaction.getOrder().getNumber(), equalTo("1234"));
		assertThat(transaction.getOrder().getAmount(), equalTo(100l));
		assertThat(transaction.getOrder().getCurrency(), equalTo(CieloCurrency.REAL));
		assertThat(transaction.getOrder().getLang(), equalTo(CieloLanguage.PT));
		assertThat(transaction.getUrlAuthentication(), equalTo(urlAuthentication));
	}

}
