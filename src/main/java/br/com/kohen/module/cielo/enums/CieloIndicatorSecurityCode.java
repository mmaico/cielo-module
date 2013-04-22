package br.com.kohen.module.cielo.enums;

public enum CieloIndicatorSecurityCode {

	INFORMED(1),
	UNINFORMED(0),
	ILLEGIBLE(2),
	ABSENT(9);
	
	private short code;

	private CieloIndicatorSecurityCode(int codigo) {
		this.code = (short) codigo;
	}

	public short getCode() {
		return code;
	}		
}
