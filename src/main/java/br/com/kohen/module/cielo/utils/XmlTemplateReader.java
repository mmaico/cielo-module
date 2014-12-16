package br.com.kohen.module.cielo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import br.com.kohen.module.cielo.exception.XmlTemplateNotFoundException;

public class XmlTemplateReader {

	private static Map<TemplateTransaction, String> templates = new HashMap<TemplateTransaction, String>();
	
	public enum TemplateTransaction {
		NEW, CHECK 
	}
	
	static {
		InputStream inputNewTransaction = XmlTemplateReader.class.getResourceAsStream("/requisicao-transacao-template.xml");
		InputStream inputCheckTrasaction = XmlTemplateReader.class.getResourceAsStream("/requisicao-consulta-template.xml");
		
		try {
			templates.put(TemplateTransaction.NEW, IOUtils.toString(inputNewTransaction));
			templates.put(TemplateTransaction.CHECK, IOUtils.toString(inputCheckTrasaction));
		} catch (IOException e) {
			throw new XmlTemplateNotFoundException(e);
		}
	}
	
	public static String get(TemplateTransaction template) {
		return templates.get(template);
	}

}
