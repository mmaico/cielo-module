package br.com.kohen.module.cielo.entity;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BusinessEstablishmentTest {

	
	@Test
	public void shouldBuildWithParametersOfPropertiesFile() {
		String keyExpected = "e84827130b9837473681c2787007da5914d6359947015a5cdb2b8843db0fa832";
		String numberExpected = "1001734898";
		BusinessEstablishment establishment = BusinessEstablishment.build();
		
		assertThat(establishment.getKey(), Matchers.equalTo(keyExpected));
		assertThat(establishment.getNumber(), Matchers.equalTo(numberExpected));
	}

}
