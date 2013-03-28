package br.com.kohen.module.cielo.enums;

public enum Currency {
	REAL(986), DOLAR(000), EURO(000);
	
	private Integer code; 
	
	Currency(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
}
