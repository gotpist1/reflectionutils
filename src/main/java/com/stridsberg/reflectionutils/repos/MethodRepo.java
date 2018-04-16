package com.stridsberg.reflectionutils.repos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public interface MethodRepo {

	public Method getMethodByNameAndArgs(String methodName, Class<?>... argsClasses)
			throws NoSuchMethodException, SecurityException;

	public Method getPrivateMethodByNameAndArgs(String methodName, Class<?>... argsClasses)
			throws NoSuchMethodException, SecurityException;

	public List<Method> getMethods();

	public List<Method> getAllMethods();

	public List<Method> getAllMethodsVisiable();

	public <T> T invokeMethod(String methodName, Object... args);

	public <T> T invokeMethod(Method method, Object... args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException;

	public <T> T invokeMethodByName(String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException,
			NoSuchMethodException, SecurityException;
}
