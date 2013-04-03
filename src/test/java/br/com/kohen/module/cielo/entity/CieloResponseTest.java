package br.com.kohen.module.cielo.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import br.com.kohen.module.cielo.entity.infra.ReadXmlToTest;

public class CieloResponseTest {

	private String messageError = "<erro xmlns=\"http://ecommerce.cbmp.com.br\">" 
								+ "		<codigo>002</codigo>"
								+ "		<mensagem>Credenciais inv‡lidas.</mensagem>"
								+ "	</erro>";
	
	@Test
	public void shouldCreateResponseWithError() {
		Boolean hasError = CieloResponse.build(this.messageError).hasError();
		
		assertThat(hasError, is(Boolean.TRUE));
	}
	
	@Test
	public void shouldMountingTheResponseTransaction() {
		String responseMessage = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		CieloTransaction transaction = CieloResponse.build(responseMessage).getTransaction();
		
		assertThat(transaction.isNullObject(), notNullValue());
	}

	@Test
	public void shouldReturnFalseWhenResponseNotHaveAValidTransation() {
		
		CieloResponse response = CieloResponse.build(this.messageError);
		
		assertThat(response.isValid(), is(Boolean.FALSE));
	}
	
	public void shouldReturnTrueWhenHaveAValidTransation() {
		String responseMessage = ReadXmlToTest.read("/xmlReturn/newTrasaction-success-buy-cielo-page-return.xml");
		CieloResponse response = CieloResponse.build(responseMessage);
		
		assertThat(response.isValid(), is(Boolean.TRUE));
	}
}
