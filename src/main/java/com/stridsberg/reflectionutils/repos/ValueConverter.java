package com.stridsberg.reflectionutils.repos;

public interface ValueConverter {

	public <T> T convertValue(Class<?> convertTo,Object value);
	
}
