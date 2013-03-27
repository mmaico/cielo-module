package br.com.kohen.module.cielo.entity;

/**
 * Model transaction was based on the example of cielo. 
 *
 */
public class CieloTransaction {

	private String urlAuthentication;
	
	private String tid;

	private short status;
	
	private String pan;
	
	private Authentication authentication;
	
	private Authorization authorization;
	
	private Cancellation cancellation;
	
	private Capture capture;
	
	private OrderData dadosPedido;
	
	private Payment payment;
	
	
	public String getUrlAuthentication() {
		return urlAuthentication;
	}

	public void setUrlAuthentication(String urlAuthentication) {
		this.urlAuthentication = urlAuthentication;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public Cancellation getCancellation() {
		return cancellation;
	}

	public void setCancellation(Cancellation cancellation) {
		this.cancellation = cancellation;
	}

	public Capture getCapture() {
		return capture;
	}

	public void setCapture(Capture capture) {
		this.capture = capture;
	}

	public OrderData getDadosPedido() {
		return dadosPedido;
	}

	public void setDadosPedido(OrderData dadosPedido) {
		this.dadosPedido = dadosPedido;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/** All classes that make up the transaction*/
	
	public class Processing {
		short code;
		String message;
		String dateAndTime;
		long amount;
	}

	public class Authentication extends Processing {
		short eci;
	}
	
	public class Authorization extends Processing {
		String lr;
		String code;
		String arp;
		String nsu;
		
		public String getLr() {
			return lr;
		}
		
		public String getCode() {
			return code;
		}

		public String getArp() {
			return arp;
		}
	}
	
	public class Cancellation extends Processing {
	}
	
	public class Capture extends Processing {
	}
	
	public class OrderData {
		String number;
		long amount;
		short currency;
		String dateAndTime;
		String language;
		String description;
		
		public String getNumber() {
			return number;
		}
		public long getAmount() {
			return amount;
		}
		
		
	}
	
	class Payment {
		String flagCreditCard;
		String product;
		short plots;
	}
}
