package br.com.kohen.module.cielo.entity;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BusinessEstablishmentTest {

	
	@Test
	public void shouldBuildWithParametersOfPropertiesFile() {
		BusinessEstablishment establishment = BusinessEstablishment.build();
		
		assertThat(establishment.getKey(), Matchers.equalTo("chave"));
		assertThat(establishment.getNumber(), Matchers.equalTo("1234"));
	}

}
