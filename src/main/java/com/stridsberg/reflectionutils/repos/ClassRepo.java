package com.stridsberg.reflectionutils.repos;

import java.util.Map;

public interface ClassRepo {
	public Class<?> getParameterizedClass();

	public <T> T instantiateHiddenConstructor(Object... params);

	public <T> T populateBeanFromMap(Map<String, ? extends Object> beanMap);

	public <T> T populateBeanFromMap(Map<String, String> beanMap, ValueConverter converter);
}
