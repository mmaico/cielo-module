package br.com.kohen.module.cielo.entity;

import br.com.kohen.module.cielo.utils.PropertiesAcessor;


public class BusinessEstablishment {

	private String number;
	
	private String key;

	private BusinessEstablishment(){
		this.number = PropertiesAcessor.load().getProperty("businessEstablishment.number");
		this.key = PropertiesAcessor.load().getProperty("businessEstablishment.key");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusinessEstablishment other = (BusinessEstablishment) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
}
