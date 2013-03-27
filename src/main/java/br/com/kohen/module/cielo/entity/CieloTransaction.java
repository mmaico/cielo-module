package br.com.kohen.module.cielo.entity;

public class CieloTransaction {

	private String urlAuthentication;
	private String tid;
	private short status;
	private String pan;
	private CieloOrder order;
	
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
	
}
