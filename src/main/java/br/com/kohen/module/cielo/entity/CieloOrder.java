package br.com.kohen.module.cielo.entity;

import java.util.Date;

import br.com.kohen.module.cielo.enums.CieloCurrency;
import br.com.kohen.module.cielo.enums.CieloLanguage;
import br.com.kohen.module.cielo.utils.PropertiesAcessor;

public class CieloOrder {

	private String number;
	private long amount;
	private Long airportTaxes;
	private Date date;
	private CieloLanguage lang;
	private CieloCurrency currency;
	private String description;
	private String softDescriptor;
	
	public CieloOrder() {
		String currencyString = PropertiesAcessor.load().getProperty("cieloOrder.currency");
		String langString = PropertiesAcessor.load().getProperty("cieloOrder.lang");
		
		if(currencyString!=null) this.currency = CieloCurrency.valueOf(currencyString);
		if(langString!=null) this.lang = CieloLanguage.valueOf(langString);
		this.softDescriptor = PropertiesAcessor.load().getProperty("cieloOrder.softDescriptor");
		this.date = new Date();
	}
	
	/**
	 * @return A order identified created by the store.
	 * It's highly recommended that it is unique,
	 * but it is on charge of the store.
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number A order identified created by the store.
	 * It's highly recommended that it is unique,
	 * but it is on charge of the store.
	 * 
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * How much the order costs in cents.
	 * @return How much the Order costs.
	 */
	public long getAmount() {
		return amount;
	}
	
	/**
	 * Sets how much the order costs in cents.
	 * It must include all dispenses that the order has
	 * like shipping or package bag.
	 * @param amount The value to be set.
	 */
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
	
	/**
	 * The language to be used in Cielo Pages
	 * if the modality is BuyPage Cielo.
	 * If not provided portuguese will be used.
	 * @param lang
	 */
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
	
	/**
	 * @see #setNumber(String)
	 */
	public CieloOrder withNumber(String number) {
		this.number = number;
		return this;
	}
	
	/**
	 * @see #setAmount(long)
	 */
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
	
	/**
	 * @see #setLang(CieloLanguage) 
	 */
	public CieloOrder withLang(CieloLanguage lang) {
		this.lang = lang;
		return this;
	}
	
	/**
	 * @see #setSoftDescriptor(String) 
	 */
	public CieloOrder withSoftDescritor(String softDescriptor){
		this.softDescriptor = softDescriptor;
		return this;
	}
	
	public CieloOrder withAirportTaxes(Long airportTaxes) {
		this.airportTaxes = airportTaxes;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSoftDescriptor() {
		return softDescriptor;
	}

	/**
	 * Sets the softDescritor
	 * @param softDescriptor a text not bigger than 13 characters that
	 * will appear on clients credit card bill
	 */
	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}

	public Long getAirportTaxes() {
		return airportTaxes;
	}

	public void setAirportTaxes(Long airportTaxes) {
		this.airportTaxes = airportTaxes;
	}
	
}
