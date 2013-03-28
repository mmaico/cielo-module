package br.com.kohen.module.cielo.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.node.SimpleNode;

public class XmlTemplateUtils {

	
	
	public static String mergeTemplateIntoString(String templateStr, Map<String, Object> params) {
		
		try {
			RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
			StringReader reader = new StringReader(templateStr);
			SimpleNode node = runtimeServices.parse(reader, "template");
			
			StringWriter result = new StringWriter();
			VelocityContext context = new VelocityContext(params);
			
			Template template = new Template();
			template.setRuntimeServices(runtimeServices);
			template.setData(node);
			template.initDocument();

			template.merge(context, result);
			
			return result.toString();
		} catch (Exception e) {
			return "";
		} 
		
	}
}
