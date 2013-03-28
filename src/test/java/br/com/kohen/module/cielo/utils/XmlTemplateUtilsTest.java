package br.com.kohen.module.cielo.utils;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class XmlTemplateUtilsTest {

	@Test
	public void shouldMergeTemplateWithParameters() {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("param", null);
		
		String templateDone = XmlTemplateUtils.mergeTemplateIntoString(templateStub(), params);
		
		assertThat(templateDone, is("Usuario com email: kohen@email.com.br"));
	}

	@Test
	public void shouldMergeRemplateUsingVelocityWordReserved () {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("param", null);
		
		String templateDone = XmlTemplateUtils.mergeTemplateIntoString(templateWithWordReservedStub(), params);
		
		assertThat(templateDone, is("  id igual a 1 "));
		
	}
	
	private String templateStub() {
		
		StringBuilder template = new StringBuilder();
		template.append("");
		
		return template.toString();
	}
	
	private String templateWithWordReservedStub() {
		StringBuilder template = new StringBuilder();
		template.append("param");
		
		return template.toString();
		
	}

}
