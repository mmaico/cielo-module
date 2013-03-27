package br.com.kohen.module.cielo.entity;

import java.util.Date;

public class CieloOrder {

	private String number;
	private long amount;
	private Date date;
	private CieloPayment payment;
	
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
	public CieloPayment getPayment() {
		return payment;
	}
	public void setPayment(CieloPayment payment) {
		this.payment = payment;
	}
	
}
