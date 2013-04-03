package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.CreditCardType;
import br.com.kohen.module.cielo.enums.Modality;

public class CieloPayment {

	private CieloCard card;
	
	private CreditCardType creditCardType;

	private Modality modality;
	
	private Integer plots = 1;
	
	
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
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
	
	public CieloPayment withCreditCardType(CreditCardType type) {
		this.creditCardType = type;
		return this;
	}
	
	public CieloPayment withModality(Modality modality) {
		this.modality = modality;
		return this;
	}
	
	public CieloPayment withPlots(Integer quantityPlots) {
		this.plots = quantityPlots;
		return this;
	}
	
}
