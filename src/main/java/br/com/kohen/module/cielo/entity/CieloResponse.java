package br.com.kohen.module.cielo.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.kohen.module.cielo.utils.XmlToCieloTransaction;



public class CieloResponse implements AbstractResponse {

	private CieloTransaction transaction;
	private Integer statusCode;
	private String message = "";

	public CieloResponse(String message) {
		this.message = message;
	}
	public CieloResponse addMessage(String message) {
		this.message = message;
		return this;
	}

	public CieloResponse addStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public CieloResponse addTransaction(CieloTransaction transaction) {
		this.transaction = transaction;
		return this;
	}

	public Boolean isValid() {
		if (this.transaction == null || this.transaction.isNullObject()) { 
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	public CieloTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(CieloTransaction transaction) {
		this.transaction = transaction;
	}

	public Integer getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Boolean hasError() {
		Pattern pattern = Pattern.compile("<erro .*?>*.?</erro>");
		Matcher matcher = pattern.matcher(this.message);
		return matcher.find();
	}
	
	public static CieloResponse build(String message) {
		CieloResponse cieloResponse = new CieloResponse(message);
		
		CieloTransaction cieloTransaction = XmlToCieloTransaction.getInstance().create(cieloResponse.getMessage());
		cieloResponse.setTransaction(cieloTransaction);
		
		return cieloResponse;
	}

}