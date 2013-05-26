package br.com.kohen.module.cielo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CieloAuthorization {

	private Integer code;
	private String message;
	private Date date;
	private BigDecimal value;
	private String lr;
	private String nsu;
	private String arp;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getLr() {
		return lr;
	}
	public void setLr(String lr) {
		this.lr = lr;
	}
	public String getNsu() {
		return nsu;
	}
	public void setNsu(String nsu) {
		this.nsu = nsu;
	}
	public String getArp() {
		return arp;
	}
	public void setArp(String arp) {
		this.arp = arp;
	}
	
}
