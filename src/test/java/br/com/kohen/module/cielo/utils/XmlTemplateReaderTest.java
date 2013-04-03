package br.com.kohen.module.cielo.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

public class XmlTemplateReaderTest {

	
	@Test
	public void shouldReturnTheTemplateOfTransactionByCieloPage() throws IOException {
		InputStream inputStream = XmlTemplateReader.class.getResourceAsStream("/requisicao-transacao.buypagecielo-template.xml");
		
		String contentTemplate = XmlTemplateReader.getTemplateTransactionByPageCielo();
		
		assertThat(contentTemplate, Matchers.containsString(IOUtils.toString(inputStream)));
	}

}
