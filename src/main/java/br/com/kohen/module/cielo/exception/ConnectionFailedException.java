package br.com.kohen.module.cielo.exception;

public class ConnectionFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionFailedException(String arg0) {
		super(arg0);
	}

	public ConnectionFailedException(Throwable arg0) {
		super(arg0);
	}

	public ConnectionFailedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
