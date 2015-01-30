package br.com.kohen.module.cielo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.kohen.module.cielo.exception.PropertiesNotFoundException;

public class PropertiesAcessor {

	private static Properties properties;
	
	public static Properties load() {
		if(properties == null){
			try {
				InputStream inputStream = PropertiesAcessor.class.getResourceAsStream(getFileName());
				
				properties = new Properties();
				properties.load(inputStream);
			} catch (IOException e) {
				properties = null;
				throw new PropertiesNotFoundException(e);
			}
		}
		return properties;
	}
	
	static String getFileName() {
		return "/payment-config.properties";
	}

}
