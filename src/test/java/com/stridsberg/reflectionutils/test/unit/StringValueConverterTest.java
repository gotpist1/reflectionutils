package com.stridsberg.reflectionutils.test.unit;

import java.util.Date;

import org.junit.Test;

import com.stridsberg.reflectionutils.util.StringValueConverter;

public class StringValueConverterTest {

	TestClass<String> test = new TestClass<String>();
	
	StringValueConverter converter = new StringValueConverter();

	@Test
	public void testGetParameterizedClass() {
		int t = converter.convertValue(Integer.class, "2");
		System.out.println(t);
	}
	
}
