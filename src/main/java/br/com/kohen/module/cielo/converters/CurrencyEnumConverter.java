package br.com.kohen.module.cielo.converters;

import br.com.kohen.module.cielo.enums.Currency;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CurrencyEnumConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return type.equals(Currency.class);
	}

	public void marshal(Object source, HierarchicalStreamWriter write,
			MarshallingContext context) {
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		String currencyCode = reader.getValue();
		
		Currency currency = Currency.getByCode(Integer.valueOf(currencyCode));
		
		return currency;
	}

}
