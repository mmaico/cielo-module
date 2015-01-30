package br.com.kohen.module.cielo.ws.impl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import br.com.kohen.module.cielo.entity.BusinessEstablishment;
import br.com.kohen.module.cielo.entity.CieloResponse;
import br.com.kohen.module.cielo.entity.CieloTransaction;
import br.com.kohen.module.cielo.exception.ConnectionFailedException;
import br.com.kohen.module.cielo.utils.PropertiesAcessor;
import br.com.kohen.module.cielo.utils.XmlTemplateReader.TemplateTransaction;
import br.com.kohen.module.cielo.ws.CieloWebService;

public class CieloWebServiceImpl implements CieloWebService {

	private static final int ONE_SECOUND = 1000;
	private static final int _CONNECTION_TIMEOUT = 10 * ONE_SECOUND;

	private final String URL_WS;
	
	public CieloWebServiceImpl() {
		URL_WS = PropertiesAcessor.load().getProperty("cielo.url.webservice");
	}
	
	public CieloWebServiceImpl(String urlWebService) {
		URL_WS = urlWebService;
	}
	
	public CieloResponse newTransaction(CieloTransaction transaction) {
		
		return callWS(transaction, TemplateTransaction.NEW);
	}

	public CieloResponse findTransaction(String tid, BusinessEstablishment bEstablishment) {
		
		CieloTransaction transaction = CieloTransaction.build()
			.withBusinessEstablishment(bEstablishment)
			.withTid(tid);
		
		return callWS(transaction, TemplateTransaction.CHECK);
	}
	
	private CieloResponse callWS(CieloTransaction transaction, TemplateTransaction template) {
		
		String content = "";
		try {
			
			content = Request.Post(URL_WS)
					.connectTimeout(_CONNECTION_TIMEOUT)
					.bodyForm(Form.form().add("mensagem", transaction.toXml(template)).build())
					.execute().returnContent().asString();
			
		} catch (ClientProtocolException e) {
			throw new ConnectionFailedException(e);
		} catch (IOException e) {
			throw new ConnectionFailedException(e);
		}
		
		return CieloResponse.build(content);
	}

}
