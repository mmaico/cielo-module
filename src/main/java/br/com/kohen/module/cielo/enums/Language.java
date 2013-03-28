package br.com.kohen.module.cielo.enums;

public enum Language {

	PT, EN;

	public static Language get(String lang) {
		
		for (Language language : values()) {
			if (language.getName().equalsIgnoreCase(lang))
				return language;
		}
		
		return Language.PT;
	}

	public static boolean exist(String lang) {
		
		for (Language language : values()) {
			if (language.getName().equals(lang)) {
				return true;
			}	
		}
		
		return false;
	}

	public String getName() {
		return this.toString().toLowerCase();
	}
}
