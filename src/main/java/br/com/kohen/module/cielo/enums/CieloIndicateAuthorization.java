package br.com.kohen.module.cielo.enums;


public enum CieloIndicateAuthorization {

	AUTHORIZE_DIRECT(3, "Autorizar Direto"),
	AUTHORIZE_CERTIFIED_NOTCERTIFIED(2, "Autorizar transacao autenticada e nao-autenticada"),
	NOT_AUTHORIZE(0, "Somente autenticar a transacao"),
	AUTHORIZE_CERTIFIED(1, "Autorizar transacao somente se autenticada");

	private short code;
	
	private String description;
	
	private CieloIndicateAuthorization(int codigo, String description) {
		this.code = (short) codigo;
		this.description = description;
	}
	
	public short getCode() {
		return code;
	}
	
	public String getDescription() {
		return this.description;
	}

	public static CieloIndicateAuthorization valueOf(int code) {
		
		for (CieloIndicateAuthorization indicator : values()) {
			if (indicator.getCode() == code) {
				return indicator;
			}
		}
		
		throw new IllegalArgumentException("Invalid parameter");
	}

}
