package br.com.kohen.module.cielo.converters;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return type.equals(Date.class);
	}

	public void marshal(Object source, HierarchicalStreamWriter write,
			MarshallingContext context) {
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		String stringDate = reader.getValue();
		
		Calendar calendar = DatatypeConverter.parseDateTime(stringDate);
		
		return calendar.getTime();
	}

}
