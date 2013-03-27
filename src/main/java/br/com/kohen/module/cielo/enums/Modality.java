package br.com.kohen.module.cielo.enums;

public enum Modality {

	CASH_PAYMENT('1', "Credito a Vista"),
	DEBIT('A', "Debito"),
	INSTALLMENTS_ADMISTRATOR('3', "Parcelado pela adiministradora"),
	INSTALLMENTS_BUSINESS_STABLISHMENT('2', "Parcelado pela loja")
	;
	
	private char codigo;
	
	private String descricao;
	
	private Modality(char codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public char getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
