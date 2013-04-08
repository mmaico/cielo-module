package br.com.kohen.module.cielo.utils;

import br.com.kohen.module.cielo.converters.CardTypeEnumConverter;
import br.com.kohen.module.cielo.converters.CurrencyEnumConverter;
import br.com.kohen.module.cielo.converters.DateConverter;
import br.com.kohen.module.cielo.converters.ModalityEnumConverter;
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
		
		xStream.aliasAttribute(CieloTransaction.class, "id", "id");
		xStream.aliasAttribute(CieloTransaction.class, "order", "dados-pedido");
		xStream.aliasAttribute(CieloTransaction.class, "urlAuthentication", "url-autenticacao");
		xStream.aliasAttribute(CieloTransaction.class, "payment", "forma-pagamento");
		
		xStream.aliasAttribute(CieloOrder.class, "date", "data-hora");
		xStream.aliasAttribute(CieloOrder.class, "number", "numero");
		xStream.aliasAttribute(CieloOrder.class, "amount", "valor");
		xStream.aliasAttribute(CieloOrder.class, "currency", "moeda");
		xStream.aliasAttribute(CieloOrder.class, "lang", "idioma");
		xStream.aliasAttribute(CieloOrder.class, "description", "descricao");
		
		xStream.aliasAttribute(CieloPayment.class, "creditCardType", "bandeira");
		xStream.aliasAttribute(CieloPayment.class, "modality", "produto");
		xStream.aliasAttribute(CieloPayment.class, "plots", "parcelas");
	}
	
	public static XmlToCieloTransaction getInstance() {
		return INSTANCE;
	}
	
	public CieloTransaction create(String xml) {
		CieloTransaction transaction = CieloTransaction.nullObject();
		
		try {
			transaction = (CieloTransaction) xStream.fromXML(xml);
		} catch(CannotResolveClassException e) {}
		
		return transaction;
	}
	
}
