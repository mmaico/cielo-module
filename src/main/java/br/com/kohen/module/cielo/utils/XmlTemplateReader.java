package br.com.kohen.module.cielo.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import br.com.kohen.module.cielo.exception.XmlTemplateNotFoundException;

public class XmlTemplateReader {

	public XmlTemplateReader() {}
	
	public static String getTemplateTransactionByPageCielo() {
		InputStream inputStream = XmlTemplateReader.class.getResourceAsStream("/requisicao-transacao.buypagecielo-template.xml");
		try {
			return IOUtils.toString(inputStream);
		} catch (IOException e) {
			throw new XmlTemplateNotFoundException(e);
		}
	}

}
