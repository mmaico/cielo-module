package br.com.kohen.module.cielo.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class PropertiesAcessorTest {


	@Test
	public void shouldReadTheProperties() {
		
		String property = PropertiesAcessor.load().getProperty("cielo.establishment.number");
		
		assertThat(property, equalTo("1001734898"));
	}

}
