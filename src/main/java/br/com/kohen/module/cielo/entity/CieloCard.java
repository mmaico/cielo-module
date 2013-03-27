package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.IndicatorSecurityCode;

public class CieloCard {

	private String number;
	
	private String validity;
	
	private IndicatorSecurityCode securityCode;
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public IndicatorSecurityCode getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(IndicatorSecurityCode securityCode) {
		this.securityCode = securityCode;
	}
	
}
