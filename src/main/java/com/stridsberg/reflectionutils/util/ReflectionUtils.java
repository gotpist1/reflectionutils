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
			t = new MethodImpl(classHolder).invokeMethod(methodName, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public static <T> T invokeMethod(Method method, Object... args) {
		T t = null;
		try {
			t = new MethodImpl(method.getDeclaringClass()).invokeMethod(method, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public static Method getMethod(Class<?> classHolder,String methodName, Class<?>... argsClasses) {
		Method method = null;
		try {
			method = new MethodImpl(classHolder).getMethodByNameAndArgs(methodName, argsClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return method;
	}

}
