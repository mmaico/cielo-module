package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.CreditCardType;
import br.com.kohen.module.cielo.enums.Modality;

public class CieloPayment {

	private CieloCard card;
	
	private CreditCardType creditCardType;

	private Modality modality;
	
	private Integer parcelas = 1;
	
	
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

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public CieloCard getCard() {
		return card;
	}

	public void setCard(CieloCard card) {
		this.card = card;
	}
}
