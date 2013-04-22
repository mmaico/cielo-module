package br.com.kohen.module.cielo.entity;

import java.util.Date;

import br.com.kohen.module.cielo.enums.CieloCurrency;
import br.com.kohen.module.cielo.enums.CieloLanguage;

public class CieloOrder {

	private String number;
	private long amount;
	private Date date;
	private CieloLanguage lang;
	private CieloCurrency currency;
	private String description;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CieloLanguage getLang() {
		return lang;
	}
	public void setLang(CieloLanguage lang) {
		this.lang = lang;
	}
	public CieloCurrency getCurrency() {
		return currency;
	}
	public void setCurrency(CieloCurrency currency) {
		this.currency = currency;
	}
	
	public static CieloOrder build() {
		return new CieloOrder();
	}
	
	public CieloOrder withNumber(String number) {
		this.number = number;
		return this;
	}
	
	public CieloOrder withAmount(Long amount) {
		this.amount = amount;
		return this;
	}
	
	public CieloOrder withCurrency(CieloCurrency currency) {
		this.currency = currency;
		return this;
	}
	
	public CieloOrder withDate(Date dateTransaction) {
		this.date = dateTransaction;
		return this;
	}
	
	public CieloOrder withLang(CieloLanguage lang) {
		this.lang = lang;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
