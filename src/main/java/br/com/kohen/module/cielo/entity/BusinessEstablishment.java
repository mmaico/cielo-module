package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.utils.PropertiesAcessor;


public class BusinessEstablishment {

	private String number;
	
	private String key;

	private BusinessEstablishment(){
		this.number = PropertiesAcessor.load().getProperty("cielo.establishment.number");
		this.key = PropertiesAcessor.load().getProperty("cielo.establishment.key");
	}
	
	public String getNumber() {
		return number;
	}

	public String getKey() {
		return key;
	}
	
	public static BusinessEstablishment build() {
		return new BusinessEstablishment();
	}
	
	public  BusinessEstablishment withNumber(String number) {
		this.number = number;
		return this;
	}
	
	public  BusinessEstablishment withKey(String key) {
		this.key = key;
		return this;
	}
}
