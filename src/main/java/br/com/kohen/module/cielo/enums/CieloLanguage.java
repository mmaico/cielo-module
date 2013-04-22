package br.com.kohen.module.cielo.enums;

public enum CieloLanguage {

	PT, EN;

	public static CieloLanguage get(String lang) {
		
		for (CieloLanguage language : values()) {
			if (language.getName().equalsIgnoreCase(lang))
				return language;
		}
		
		return CieloLanguage.PT;
	}

	public static boolean exist(String lang) {
		
		for (CieloLanguage language : values()) {
			if (language.getName().equals(lang)) {
				return true;
			}	
		}
		
		return false;
	}

	public String getName() {
		return this.toString().toUpperCase();
	}
}
