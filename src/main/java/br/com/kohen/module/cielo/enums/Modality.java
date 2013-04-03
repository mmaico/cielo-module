package br.com.kohen.module.cielo.enums;

public enum Modality {

	CASH_PAYMENT("1", "Credito a Vista"),
	DEBIT("A", "Debito"),
	INSTALLMENTS_ADMISTRATOR("3", "Parcelado pela adiministradora"),
	INSTALLMENTS_BUSINESS_STABLISHMENT("2", "Parcelado pela loja")
	;
	
	private String code;
	
	private String description;
	
	private Modality(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescricao() {
		return description;
	}
	
	public static Modality getByCode(String code) {
		
		for (Modality modality : values()) {
			
			if (modality.getCode().equalsIgnoreCase(code)) {
				return modality;
			}
		}
		
		throw new IllegalArgumentException("Code not found");
	}
	
}
