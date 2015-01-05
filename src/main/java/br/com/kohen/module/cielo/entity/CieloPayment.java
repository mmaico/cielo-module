package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.CieloCreditCardType;
import br.com.kohen.module.cielo.enums.CieloModality;

public class CieloPayment {

	private CieloCard card;
	
	private CieloCreditCardType creditCardType;

	private CieloModality modality;
	
	private Integer plots = 1;
	
	
	public CieloCreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CieloCreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public CieloModality getModality() {
		return modality;
	}

	public void setModality(CieloModality modality) {
		this.modality = modality;
	}

	public Integer getPlots() {
		return plots;
	}

	public void setPlots(Integer plots) {
		this.plots = plots;
	}

	public CieloCard getCard() {
		return card;
	}

	public void setCard(CieloCard card) {
		this.card = card;
	}
	
	public static CieloPayment build() {
		return new CieloPayment();
	}
	
	public CieloPayment withCreditCardType(CieloCreditCardType type) {
		this.creditCardType = type;
		return this;
	}
	
	public CieloPayment withModality(CieloModality modality) {
		this.modality = modality;
		return this;
	}
	
	public CieloPayment withPlots(Integer quantityPlots) {
		this.plots = quantityPlots;
		return this;
	}
	
	public CieloPayment withCieloCard(CieloCard card) {
		this.card = card;
		return this;
	}
	
}
