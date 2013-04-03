package br.com.kohen.module.cielo.exception;

public class XmlTemplateNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XmlTemplateNotFoundException(String arg0) {
		super(arg0);
	}

	public XmlTemplateNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public XmlTemplateNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
