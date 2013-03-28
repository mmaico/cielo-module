package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.CreditCardType;
import br.com.kohen.module.cielo.enums.Modality;
import br.com.kohen.module.cielo.enums.Product;

public class CieloPayment {

	private CieloCard card;
	
	private CreditCardType creditCardType;

	private Modality modality;
	
	private Integer plots = 1;
	
	private Product product;
	
	
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
