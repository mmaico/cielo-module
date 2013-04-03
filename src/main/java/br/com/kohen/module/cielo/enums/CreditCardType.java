package br.com.kohen.module.cielo.enums;

public enum CreditCardType {

	VISA("visa"),
	MASTERCARD("mastercard"),
	ELO("elo"),
	DINERS("diners"),
	DISCOVER("discover");
	
	private String type;
	
	CreditCardType(String type) {
		this.type = type;
	}

	public String getType() {
		return type.toUpperCase();
	}

	public static CreditCardType get(String type) {
		
		for (CreditCardType typeEnum : values()) {
			
			if (typeEnum.type.equalsIgnoreCase(type)) {
				return typeEnum;
			}
		}
		
		throw new IllegalArgumentException("Invalid argument!");
	}
	
}
