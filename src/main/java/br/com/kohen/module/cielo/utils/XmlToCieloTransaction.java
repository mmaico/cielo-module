package br.com.kohen.module.cielo.utils;

import br.com.kohen.module.cielo.converters.CardTypeEnumConverter;
import br.com.kohen.module.cielo.converters.CurrencyEnumConverter;
import br.com.kohen.module.cielo.converters.DateConverter;
import br.com.kohen.module.cielo.converters.ModalityEnumConverter;
import br.com.kohen.module.cielo.entity.Cancellation;
import br.com.kohen.module.cielo.entity.CieloCaptureInfo;
import br.com.kohen.module.cielo.entity.CieloAuthentication;
import br.com.kohen.module.cielo.entity.CieloAuthorization;
import br.com.kohen.module.cielo.entity.CieloOrder;
import br.com.kohen.module.cielo.entity.CieloPayment;
import br.com.kohen.module.cielo.entity.CieloTransaction;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

/**
 * 
 * based by cielo example.
 *
 */

public class XmlToCieloTransaction {
	
	private static final XmlToCieloTransaction INSTANCE = new XmlToCieloTransaction();
	
	private XStream xStream;
	
	private XmlToCieloTransaction() {
		xStream = new XStream();
		xStream.registerConverter(new CurrencyEnumConverter());
		xStream.registerConverter(new DateConverter());
		xStream.registerConverter(new CardTypeEnumConverter());
		xStream.registerConverter(new ModalityEnumConverter());
		
		xStream.alias("transacao", CieloTransaction.class);
		xStream.alias("retorno-tid", CieloTransaction.class);
		xStream.alias("cancelamentos", Cancellation.class);
		xStream.alias("cancelamento", Cancellation.class);
		
		xStream.aliasAttribute(CieloTransaction.class, "id", "id");
		xStream.aliasAttribute(CieloTransaction.class, "order", "dados-pedido");
		xStream.aliasAttribute(CieloTransaction.class, "urlAuthentication", "url-autenticacao");
		xStream.aliasAttribute(CieloTransaction.class, "payment", "forma-pagamento");
		xStream.aliasAttribute(CieloTransaction.class, "authentication", "autenticacao");
		xStream.aliasAttribute(CieloTransaction.class, "authorization", "autorizacao");
		xStream.aliasAttribute(CieloTransaction.class, "cancellations", "cancelamentos");
		xStream.aliasAttribute(CieloTransaction.class, "captureInfo", "captura");
		
		
		xStream.aliasAttribute(CieloOrder.class, "date", "data-hora");
		xStream.aliasAttribute(CieloOrder.class, "number", "numero");
		xStream.aliasAttribute(CieloOrder.class, "amount", "valor");
		xStream.aliasAttribute(CieloOrder.class, "currency", "moeda");
		xStream.aliasAttribute(CieloOrder.class, "lang", "idioma");
		xStream.aliasAttribute(CieloOrder.class, "description", "descricao");
		xStream.aliasAttribute(CieloOrder.class, "airportTaxes", "taxa-embarque");
		xStream.aliasAttribute(CieloOrder.class, "softDescriptor", "soft-descriptor");
		
		xStream.aliasAttribute(CieloPayment.class, "creditCardType", "bandeira");
		xStream.aliasAttribute(CieloPayment.class, "modality", "produto");
		xStream.aliasAttribute(CieloPayment.class, "plots", "parcelas");
		
		xStream.aliasAttribute(CieloAuthentication.class, "code", "codigo");
		xStream.aliasAttribute(CieloAuthentication.class, "message", "mensagem");
		xStream.aliasAttribute(CieloAuthentication.class, "date", "data-hora");
		xStream.aliasAttribute(CieloAuthentication.class, "value", "valor");
		xStream.aliasAttribute(CieloAuthentication.class, "eci", "eci");
		
		xStream.aliasAttribute(CieloAuthorization.class, "code", "codigo");
		xStream.aliasAttribute(CieloAuthorization.class, "message", "mensagem");
		xStream.aliasAttribute(CieloAuthorization.class, "date", "data-hora");
		xStream.aliasAttribute(CieloAuthorization.class, "value", "valor");
		xStream.aliasAttribute(CieloAuthorization.class, "lr", "lr");
		xStream.aliasAttribute(CieloAuthorization.class, "nsu", "nsu");
		
		xStream.aliasAttribute(Cancellation.class, "code", "codigo");
		xStream.aliasAttribute(Cancellation.class, "message", "mensagem");
		xStream.aliasAttribute(Cancellation.class, "date", "data-hora");
		xStream.aliasAttribute(Cancellation.class, "value", "valor");
		
		xStream.aliasAttribute(CieloCaptureInfo.class, "code", "codigo");
		xStream.aliasAttribute(CieloCaptureInfo.class, "message", "mensagem");
		xStream.aliasAttribute(CieloCaptureInfo.class, "date", "data-hora");
		xStream.aliasAttribute(CieloCaptureInfo.class, "value", "valor");
		
	}
	
	public static XmlToCieloTransaction getInstance() {
		return INSTANCE;
	}
	
	
	/**
	 * Creates a CieloTransaction from a XML string.
	 * @param xml The XML containing the data to fill the CieloTransaction object.
	 * @return The CieloTransaction object or null if the XML is not valid.
	 */
	public CieloTransaction create(String xml) {
		CieloTransaction transaction = CieloTransaction.nullObject();
		
		try {
			transaction = (CieloTransaction) xStream.fromXML(xml);
		} catch(CannotResolveClassException e) {}
		
		return transaction;
	}
	
}
