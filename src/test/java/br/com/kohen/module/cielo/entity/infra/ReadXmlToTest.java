package br.com.kohen.module.cielo.entity.infra;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class ReadXmlToTest {

	
	@Test
	public void test() {
		
	}
	
	public static String read(String path) {
		InputStream inputStream = ReadXmlToTest.class.getResourceAsStream(path);
		
		try {
			return IOUtils.toString(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
