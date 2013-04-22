package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.CieloIndicatorSecurityCode;

public class CieloCard {

	private String number;
	
	private String validity;
	
	private CieloIndicatorSecurityCode securityCode;
	

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

	public CieloIndicatorSecurityCode getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(CieloIndicatorSecurityCode securityCode) {
		this.securityCode = securityCode;
	}
	
}
