package br.com.kohen.module.cielo.entity;

import java.util.Date;

import br.com.kohen.module.cielo.enums.Currency;
import br.com.kohen.module.cielo.enums.Language;

public class CieloOrder {

	private String number;
	private long amount;
	private Date date;
	private Language lang;
	private Currency currency;
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
	public Language getLang() {
		return lang;
	}
	public void setLang(Language lang) {
		this.lang = lang;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
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
	
	public CieloOrder withCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}
	
	public CieloOrder withDate(Date dateTransaction) {
		this.date = dateTransaction;
		return this;
	}
	
	public CieloOrder withLang(Language lang) {
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
