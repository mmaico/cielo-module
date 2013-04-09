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
import br.com.kohen.module.cielo.enums.CreditCardType;
import br.com.kohen.module.cielo.enums.Currency;
import br.com.kohen.module.cielo.enums.Language;
import br.com.kohen.module.cielo.enums.Modality;
import br.com.kohen.module.cielo.ws.impl.CieloWebServiceImpl;

public class MainTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		CieloWebServiceImpl service = new CieloWebServiceImpl();
//		CieloResponse newTransaction = service.newTransaction(getTransaction());
		CieloResponse cieloResponse = service.findTransaction("10017348980976562003", getTransaction().getbEstablishment());
		
		System.out.println(ToStringBuilder.reflectionToString(cieloResponse.getTransaction(), ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(cieloResponse.getTransaction().getUrlAuthentication());
	}

	
	private static CieloTransaction getTransaction() throws ParseException {
		Calendar calendar = DatatypeConverter.parseDateTime("2013-04-09T11:43:37");

		CieloOrder cieloOrder = CieloOrder.build().withNumber("12345")
			.withAmount(100000l)
			.withCurrency(Currency.REAL)
			.withDate(calendar.getTime())
			.withLang(Language.PT);
		
		BusinessEstablishment establishment = BusinessEstablishment.build();
		
		CieloPayment cieloPayment = CieloPayment.build().withCreditCardType(CreditCardType.VISA)
			.withPlots(3)
			.withModality(Modality.INSTALLMENTS_BUSINESS_STABLISHMENT);
		
		CieloTransaction cieloTransaction = CieloTransaction.build().withOrder(cieloOrder)
			.withBusinessEstablishment(establishment)
			.withPayment(cieloPayment);
		
		cieloTransaction.setCapture(Boolean.TRUE);	
		
		return cieloTransaction;
	}
	
}
