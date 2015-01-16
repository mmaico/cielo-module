package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.enums.CieloIndicatorSecurityCode;
import br.com.kohen.module.cielo.utils.PropertiesAcessor;

public class CieloCard {

	private String number;
	
	private String validity;
	
	private CieloIndicatorSecurityCode indicatorSecurityCode;

	private String securityCode;
	
	private String ownerName;
	
	public CieloCard() {
		String indicatorSecurityCodeString = PropertiesAcessor.load().getProperty("cieloCard.indicatorSecurityCode");
		if(indicatorSecurityCodeString!=null) this.indicatorSecurityCode = CieloIndicatorSecurityCode.valueOf(indicatorSecurityCodeString);
	}
	
	public static CieloCard build(){
		return new CieloCard();
	}

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

	public CieloIndicatorSecurityCode getIndicatorSecurityCode() {
		return indicatorSecurityCode;
	}

	public void setIndicatorSecurityCode(
			CieloIndicatorSecurityCode indicatorSecurityCode) {
		this.indicatorSecurityCode = indicatorSecurityCode;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * The name written on the card.
	 * @param ownerName A String containing the name.
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public CieloCard withNumber(String number) {
		this.number = number;
		return this;
	}

	public CieloCard withValidity(String validity) {
		this.validity = validity;
		return this;
	}

	public CieloCard withIndicatorSecurityCode(
			CieloIndicatorSecurityCode indicatorSecurityCode) {
		this.indicatorSecurityCode = indicatorSecurityCode;
		return this;
	}

	public CieloCard withSecurityCode(String securityCode) {
		this.securityCode = securityCode;
		return this;
	}
	
	public CieloCard withOwnerName(String ownerName) {
		this.ownerName = ownerName;
		return this;
	}
}
