package br.com.kohen.module.cielo.entity;



public class CieloResponse<T> {

	private T responseObject;
	private Integer statusCode;
	private String message;

	public CieloResponse<T> addMessage(String message) {
		this.message = message;
		return this;
	}

	public CieloResponse<T> addStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public CieloResponse<T> addResponseObject(T responseObject) {
		this.responseObject = responseObject;
		return this;
	}

	public Boolean isValid() {
		if (this.statusCode == null) {
			return Boolean.FALSE;
		}

		if (this.statusCode >= 200 && this.statusCode < 300) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	public T getResponseObject() {
		return this.responseObject;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}

	public Integer getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}