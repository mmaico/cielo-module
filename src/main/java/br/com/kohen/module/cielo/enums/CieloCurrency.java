package br.com.kohen.module.cielo.enums;

public enum CieloCurrency {
	REAL(986), DOLAR(000), EURO(000);
	
	private Integer code; 
	
	CieloCurrency(Integer code) {
		this.code = code;
	}
	
	public static CieloCurrency getByCode(Integer code) {
		
		for (CieloCurrency currency : values()) {
			if (currency.getCode().equals(code)) {
				return currency;
			}
		}
		
		return null;
	}
	
	public Integer getCode() {
		return this.code;
	}
}
