package br.com.kohen.module.cielo;

import java.text.ParseException;
import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import br.com.kohen.module.cielo.entity.BusinessEstablishment;
import br.com.kohen.module.cielo.entity.CieloOrder;
import br.com.kohen.module.cielo.entity.CieloPayment;
import br.com.kohen.module.cielo.entity.CieloResponse;
import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.enums.CieloCreditCardType;
import br.com.kohen.module.cielo.enums.CieloCurrency;
import br.com.kohen.module.cielo.enums.CieloLanguage;
import br.com.kohen.module.cielo.enums.CieloModality;
import br.com.kohen.module.cielo.ws.impl.CieloWebServiceImpl;

public class MainTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		CieloWebServiceImpl service = new CieloWebServiceImpl();
		BusinessEstablishment stablishment = BusinessEstablishment.build()
				.withKey("06643f09df08665f776cdd3dba93eb5252e555e7461090e9ec4049e1172f3883")
				.withNumber("1020817744");
		
		//CieloResponse cieloResponse = service.newTransaction(getTransaction());
		CieloResponse cieloResponse = service.findTransaction("10208177440000441001", stablishment);
		
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(cieloResponse.getTransaction().getUrlAuthentication());
	}

	
	private static CieloTransaction getTransaction() throws ParseException {
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
	
}
