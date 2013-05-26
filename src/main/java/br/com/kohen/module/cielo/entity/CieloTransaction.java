package br.com.kohen.module.cielo.entity;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;

import br.com.kohen.module.cielo.utils.PropertiesAcessor;
import br.com.kohen.module.cielo.utils.XmlTemplateReader;
import br.com.kohen.module.cielo.utils.XmlTemplateReader.TemplateTransaction;
import br.com.kohen.module.cielo.utils.XmlTemplateUtils;

public class CieloTransaction {

	private String id;
	private String urlAuthentication;
	private String urlToReturn;
	private String tid;
	private short status;
	private String pan;
	
	private CieloOrder order;
	
	private BusinessEstablishment bEstablishment;
	private CieloPayment payment;
	private Boolean capture = Boolean.FALSE;
	private CieloAuthentication authentication;
	private CieloAuthorization authorization;
	
	public CieloTransaction() {
		this.urlToReturn = PropertiesAcessor.load().getProperty("cielo.url.to.return");
		this.bEstablishment = BusinessEstablishment.build();
	}
	
	public String getUrlAuthentication() {
		return urlAuthentication;
	}

	public void setUrlAuthentication(String urlAuthentication) {
		this.urlAuthentication = urlAuthentication;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public CieloOrder getOrder() {
		return order;
	}

	public void setOrder(CieloOrder order) {
		this.order = order;
	}

	public BusinessEstablishment getbEstablishment() {
		return bEstablishment;
	}

	public void setbEstablishment(BusinessEstablishment bEstablishment) {
		this.bEstablishment = bEstablishment;
	}

	public CieloPayment getPayment() {
		return payment;
	}

	public void setPayment(CieloPayment payment) {
		this.payment = payment;
	}

	public String getUrlToReturn() {
		return urlToReturn;
	}

	public void setUrlToReturn(String urlToReturn) {
		this.urlToReturn = urlToReturn;
	}
	
	public Boolean getCapture() {
		return capture;
	}

	public void setCapture(Boolean capture) {
		this.capture = capture;
	}

	public static CieloTransaction build() {
		return new CieloTransaction();
	}
	
	public CieloTransaction withUrlToReturn(String url) {
		this.urlToReturn = url;
		return this;
	}
	
	public CieloTransaction withOrder(CieloOrder order) {
		this.order = order;
		return this;
	}
	
	public CieloTransaction withBusinessEstablishment(BusinessEstablishment establishment) {
		this.bEstablishment = establishment;
		return this;
	}
	
	public CieloTransaction withPayment(CieloPayment payment) {
		this.payment = payment;
		return this;
	}
	
	public CieloTransaction withTid(String tid) {
		this.tid = tid;
		return this;
	}
	
	public CieloTransaction capture() {
		this.capture = Boolean.TRUE;
		return this;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public CieloAuthentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(CieloAuthentication authentication) {
		this.authentication = authentication;
	}

	public CieloAuthorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(CieloAuthorization authorization) {
		this.authorization = authorization;
	}

	public String toXml(TemplateTransaction templateTransaction) {
		String template = XmlTemplateReader.get(templateTransaction);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("transaction", this);
		
		return XmlTemplateUtils.mergeTemplateIntoString(template, params);
	}
	
	public static CieloTransaction nullObject() {
		return new CieloTransaction();
	}
	
	public Boolean isNullObject() {
		return EqualsBuilder.reflectionEquals(this, new CieloTransaction());
	}
}
