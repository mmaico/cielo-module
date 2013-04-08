package br.com.kohen.module.cielo.utils;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.Diff;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.xml.sax.SAXException;

import br.com.kohen.module.cielo.entity.BusinessEstablishment;
import br.com.kohen.module.cielo.entity.CieloOrder;
import br.com.kohen.module.cielo.entity.CieloPayment;
import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.enums.CreditCardType;
import br.com.kohen.module.cielo.enums.Currency;
import br.com.kohen.module.cielo.enums.Language;
import br.com.kohen.module.cielo.enums.Modality;
import br.com.kohen.module.cielo.utils.XmlTemplateReader.TemplateTransaction;

public class XmlTemplateUtilsTest {


	@Test
	public void shouldMergeTemplateWithParameters() throws ParseException, IOException, SAXException {
		InputStream inputStream = XmlTemplateUtilsTest.class.getResourceAsStream("/xmlExpected/requisicao-transacao.buypagecielo-template.xml");
		String templateExpected = IOUtils.toString(inputStream);
		CieloTransaction transactionStub = getTransactionStub();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("transaction", transactionStub);
		
		String templateTransactionByPageCielo = XmlTemplateReader.get(TemplateTransaction.NEW);
		
		String templateDone = XmlTemplateUtils.mergeTemplateIntoString(templateTransactionByPageCielo, params);
		
		Diff diff = new Diff(templateExpected, templateDone);
		
		assertThat(diff.similar(), Matchers.is(Boolean.TRUE));
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
