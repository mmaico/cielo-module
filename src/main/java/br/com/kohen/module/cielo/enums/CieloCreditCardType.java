package br.com.kohen.module.cielo.enums;

public enum CieloCreditCardType {

	VISA("visa"),
	MASTERCARD("mastercard"),
	ELO("elo"),
	DINERS("diners"),
	DISCOVER("discover"),
	AMEX("amex");
	
	
	private String type;
	
	CieloCreditCardType(String type) {
		this.type = type;
	}

	public String getType() {
		return type.toUpperCase();
	}

	public static CieloCreditCardType get(String type) {
		
		for (CieloCreditCardType typeEnum : values()) {
			
			if (typeEnum.type.equalsIgnoreCase(type)) {
				return typeEnum;
			}
		}
		
		throw new IllegalArgumentException("Invalid argument!");
	}
	
}
