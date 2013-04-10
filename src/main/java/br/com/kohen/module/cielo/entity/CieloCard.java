package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.IndicatorSecurityCode;

public class CieloCard {

	private String number;
	
	private String validity;
	
	private IndicatorSecurityCode indicatorSecurityCode;
	
	private String securityCode;

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

	public IndicatorSecurityCode getIndicatorSecurityCode() {
		return indicatorSecurityCode;
	}

	public void setIndicatorSecurityCode(IndicatorSecurityCode indicatorSecurityCode) {
		this.indicatorSecurityCode = indicatorSecurityCode;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
}
