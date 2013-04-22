package br.com.kohen.module.cielo.converters;

import br.com.kohen.module.cielo.enums.CieloModality;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ModalityEnumConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return type.equals(CieloModality.class);
	}

	public void marshal(Object source, HierarchicalStreamWriter write,
			MarshallingContext context) {
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		String modalityCode = reader.getValue();
		
		CieloModality modality = CieloModality.getByCode(modalityCode);
		
		return modality;
	}

}
