package com.stridsberg.reflectionutils.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeParamHelper<T> {

	private Class<?> realType;

	public TypeParamHelper() {
		findTypeArguments(getClass());
	}

	protected void findTypeArguments(Type t) {
		if (t instanceof ParameterizedType) {
			Type[] typeArgs = ((ParameterizedType) t).getActualTypeArguments();
			realType = (Class<?>) typeArgs[0].getClass();
		} else {
			Class<?> c = (Class<?>) t;
			findTypeArguments(c.getGenericSuperclass());
		}
	}

	public Type getMyType() {
		return realType;
	}
}
