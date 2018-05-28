package com.stridsberg.reflectionutils.util;

import java.util.Date;

import org.joda.time.DateTime;

import com.stridsberg.reflectionutils.repos.ValueConverter;

public class StringValueConverter implements ValueConverter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convertValue(Class<?> convertTo, Object value) {
		String valueAsString = (String) value;
		if(convertTo.equals(String.class)) {
			return (T) valueAsString;
		}else if(convertTo.equals(Integer.class)) {
			Integer integer = Integer.parseInt(valueAsString);
			return (T) integer;
		}else if(convertTo.equals(Double.class)) {
			Double double = Double.parseDouble(valueAsString);
			
		}else if(convertTo.equals(Long.class)) {
			System.out.println("Long");
		}else if(convertTo.equals(Byte.class)) {
			System.out.println("Byte");
		}else if(convertTo.equals(Date.class)) {
			System.out.println("Date");
		}else if(convertTo.equals(DateTime.class)) {
			System.out.println("DateTime");
		}
		return null;
	}

}
