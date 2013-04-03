package br.com.kohen.module.cielo.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DateUtilTest {

	
	@Test
	public void shouldConvertDateInStringIsoDateFormat() {
		String dateExpected = "2012-12-07T13:43:37";
		Calendar calendar = DatatypeConverter.parseDateTime(dateExpected);
		
		String dateToIso = DateUtil.dateToIso(calendar.getTime());
		
		assertThat(dateToIso, equalTo(dateExpected));
	}
	
	@Test
	public void shouldReturnEmptyIfInvalidDate() {
		String dateExpected = "";
		Date date = null;
		
		String dateToIso = DateUtil.dateToIso(date);
		
		assertThat(dateToIso, equalTo(dateExpected));
	}
	
	@Test
	public void shouldConvertStringToDateIsoFormat() {
		String dateExpected = "2012-12-07T13:43:37";
		
		Date date = DateUtil.strToDateIso(dateExpected);
		
		String dateToIso = DateUtil.dateToIso(date);
		
		assertThat(dateToIso, equalTo(dateExpected));
	}
	
	@Test
	public void shouldReturnNullIfInvalidStringDate() {
		String date = "";
		
		Date dateReturned = DateUtil.strToDateIso(date);
		
		assertThat(dateReturned, Matchers.nullValue());
	}
	
	

}
