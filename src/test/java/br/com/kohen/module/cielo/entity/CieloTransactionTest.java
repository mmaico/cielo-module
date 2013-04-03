package br.com.kohen.module.cielo.entity;

import static org.hamcrest.MatcherAssert.assertThat;
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
}
