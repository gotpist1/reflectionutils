package com.stridsberg.reflectionutils.classImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.stridsberg.reflectionutils.repos.ClassRepo;
import com.stridsberg.reflectionutils.repos.ValueConverter;
import com.stridsberg.reflectionutils.util.ReflectionHelper;

public class ClassImpl extends ReflectionHelper implements ClassRepo {

	private Class<?> classHolder;

	public ClassImpl(Class<?> classHolder) {
		super(classHolder);
		this.classHolder = classHolder;
	}

	@Override
	public Class<?> getParameterizedClass() {
		// TODO Auto-generated method stub
		return getTypeParameterizedClass();
	}

	@Override
	public <T> T instantiateHiddenConstructor(Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T populateBeanFromMap(Map<String, ? extends Object> beanMap) {
	return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T populateBeanFromMap(Map<String, String> beanMap, ValueConverter converter) {
		Object bean = null;
		try {
			bean = classHolder.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Method> setters = Arrays.asList(bean.getClass().getMethods()).stream()
		.filter(method -> method.getName().contains("set"))
		.collect(Collectors.toList());
		beanMap.forEach((k,v)->{
			
		});
		

		return (T) bean;
	}

}
