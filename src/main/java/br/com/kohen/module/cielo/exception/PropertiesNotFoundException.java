package br.com.kohen.module.cielo.exception;

public class PropertiesNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertiesNotFoundException(String arg0) {
		super(arg0);
	}

	public PropertiesNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public PropertiesNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
