package com.stridsberg.reflectionutils.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.stridsberg.reflectionutils.methodImpl.MethodImpl;

public class ReflectionUtils<T> {

	public static <T> List<Method> getMethods(Class<?> classHolder) {
		return new MethodImpl(classHolder).getMethods();
	}

	public static <T> T invokeMethod(Class<?> classHolder, String methodName, Object... args) {
		T t = null;
		try {
			t = new MethodImpl(classHolder).invokePrivateMethod(methodName, args);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
