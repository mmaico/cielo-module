package br.com.kohen.module.cielo.utils;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class DateUtil {

	private static final String ISO_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	
	public static String dateToIso(Date date) {
		
		if (date == null) return "";
		
		SimpleDateFormat format = new SimpleDateFormat(ISO_PATTERN);
		return format.format(date);
	}
	
	public static Date strToDateIso(String date) {
		
		if (isBlank(date)) return null;
		
		Calendar calendar = DatatypeConverter.parseDateTime(date);
		return calendar.getTime();
	}
}
