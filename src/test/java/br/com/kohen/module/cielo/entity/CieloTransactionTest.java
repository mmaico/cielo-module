package br.com.kohen.module.cielo.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class CieloTransactionTest {

	@Test
	public void shouldReturnTrueIfIsANullObject() {
		CieloTransaction cieloTransaction = CieloTransaction.nullObject();
		
		assertThat(cieloTransaction.isNullObject(), is(Boolean.TRUE));
	}

	@Test
	public void shouldReturnFalseIfNotANullObject() {
		CieloTransaction cieloTransaction = new CieloTransaction();
		cieloTransaction.setTid("4545454");
		
		assertThat(cieloTransaction.isNullObject(), is(Boolean.FALSE));
	}
	
	@Test
	public void shouldConfigUrlReturnInConstructor() {
		String urlExpected = "http://localhost/back";
		CieloTransaction transaction = CieloTransaction.build();
		
		assertThat(transaction.getUrlToReturn(), equalTo(urlExpected));
	}
	
	@Test
	public void shouldConfigBusinessEstablishmentInConstructor() {
		String establishmentNumberExpected="1001734898";
		String establishmentKey="e84827130b9837473681c2787007da5914d6359947015a5cdb2b8843db0fa832";
		CieloTransaction transaction = CieloTransaction.build();
		
		assertThat(transaction.getbEstablishment().getNumber(), equalTo(establishmentNumberExpected));
		assertThat(transaction.getbEstablishment().getKey(), equalTo(establishmentKey));
	}
}
