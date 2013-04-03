package br.com.kohen.module.cielo.converters;

import br.com.kohen.module.cielo.enums.Modality;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ModalityEnumConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return type.equals(Modality.class);
	}

	public void marshal(Object source, HierarchicalStreamWriter write,
			MarshallingContext context) {
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		String modalityCode = reader.getValue();
		
		Modality modality = Modality.getByCode(modalityCode);
		
		return modality;
	}

}
