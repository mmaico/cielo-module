package br.com.kohen.module.cielo.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import br.com.kohen.module.cielo.utils.XmlTemplateReader.TemplateTransaction;

public class XmlTemplateReaderTest {

	
	@Test
	public void shouldReturnTheTemplateOfTransactionByCieloPage() throws IOException {
		InputStream inputStream = XmlTemplateReader.class.getResourceAsStream("/requisicao-transacao-template.xml");
		
		String contentTemplate = XmlTemplateReader.get(TemplateTransaction.NEW);
		
		assertThat(contentTemplate, containsString(IOUtils.toString(inputStream)));
	}

}
