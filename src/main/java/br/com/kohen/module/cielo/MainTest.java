package br.com.kohen.module.cielo;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import br.com.kohen.module.cielo.entity.BusinessEstablishment;
import br.com.kohen.module.cielo.entity.CieloCard;
import br.com.kohen.module.cielo.entity.CieloOrder;
import br.com.kohen.module.cielo.entity.CieloPayment;
import br.com.kohen.module.cielo.entity.CieloResponse;
import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.enums.CieloCreditCardType;
import br.com.kohen.module.cielo.enums.CieloCurrency;
import br.com.kohen.module.cielo.enums.CieloLanguage;
import br.com.kohen.module.cielo.enums.CieloModality;
import br.com.kohen.module.cielo.ws.impl.CieloWebServiceImpl;

/**
 * This class provides some examples of how to use Cielo Module and tests the system with the establishment and card info provided in Cielo manual.
 * @author Jerônimo Nunes Rocha e Marcelo Maico
 *
 */
public class MainTest {

	public static void main(String[] args) throws ParseException, InterruptedException, IOException {
		testBuyPageCielo();
		testBuyPageLoja();
	}
	
	private static void testBuyPageLoja() throws ParseException, IOException{
		CieloWebServiceImpl service = new CieloWebServiceImpl();
		
		BusinessEstablishment establishment = BusinessEstablishment.build()
				.withKey("25fbb99741c739dd84d7b06ec78c9bac718838630f30b112d033ce2e621b34f3")
				.withNumber("1006993069");
		
		CieloResponse cieloResponse = service.newTransaction(getBuyPageLojaTransaction().withBusinessEstablishment(establishment));
		System.out.println("Created new transaction");
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
		
		System.out.println("Get to your browser, finish transaction with this link, get back here and type anything.");
		System.out.println(cieloResponse.getTransaction().getUrlAuthentication());
		while(System.in.available() == 0){ }
		
		cieloResponse = service.findTransaction(cieloResponse.getTransaction().getTid(), establishment);
		System.out.println("Consulting new transaction");
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction().getCaptureInfo(), ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction().getAuthentication(),ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction().getAuthorization()));
	}

	private static void testBuyPageCielo() throws InterruptedException, ParseException, IOException{
		CieloWebServiceImpl service = new CieloWebServiceImpl();
		BusinessEstablishment establishment = BusinessEstablishment.build()
				.withKey("e84827130b9837473681c2787007da5914d6359947015a5cdb2b8843db0fa832")
				.withNumber("1001734898");
		
		CieloResponse cieloResponse = service.newTransaction(getBuyPageCieloTransaction().withBusinessEstablishment(establishment));
		System.out.println("new Transaction");
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
		
		System.out.println("Get to your browser, finish transaction with this link, get back here and type anything.");
		System.out.println(cieloResponse.getTransaction().getUrlAuthentication());
		while(System.in.available() == 0){ }
		
		cieloResponse = service.findTransaction(cieloResponse.getTransaction().getTid(), establishment);
		System.out.println("Looking for info");
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction().getCaptureInfo(), ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction().getAuthentication(),ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction().getAuthorization()));
	}
	
	private static CieloTransaction getBuyPageCieloTransaction() throws ParseException {
		Calendar calendar = DatatypeConverter.parseDateTime("2013-04-09T11:43:37");

		CieloOrder cieloOrder = CieloOrder.build().withNumber("12345")
			.withAmount(100000l)
			.withCurrency(CieloCurrency.REAL)
			.withDate(calendar.getTime())
			.withLang(CieloLanguage.EN);
		
		CieloPayment cieloPayment = CieloPayment.build().withCreditCardType(CieloCreditCardType.VISA)
			.withPlots(3)
			.withModality(CieloModality.INSTALLMENTS_BUSINESS_STABLISHMENT);
		
		CieloTransaction cieloTransaction = CieloTransaction.build().withOrder(cieloOrder)
			.withPayment(cieloPayment);
		
		cieloTransaction.setCapture(Boolean.TRUE);	
		
		return cieloTransaction;
	}
	
	private static CieloTransaction getBuyPageLojaTransaction() throws ParseException {
		CieloOrder cieloOrder = CieloOrder.build().withNumber(Integer.toString(new Random().nextInt(100000)))
			.withAmount(100000l);
		
		CieloCard card = CieloCard.build().withNumber("4012001038443335")
				.withValidity("201805").withSecurityCode("123");
		
		CieloPayment cieloPayment = CieloPayment.build().withCreditCardType(CieloCreditCardType.VISA)
			.withPlots(3).withCard(card)
			.withModality(CieloModality.INSTALLMENTS_BUSINESS_STABLISHMENT);
		
		CieloTransaction cieloTransaction = CieloTransaction.build().withOrder(cieloOrder)
			.withPayment(cieloPayment);
		
		cieloTransaction.setCapture(Boolean.TRUE);	
		
		return cieloTransaction;
	}
	
}
