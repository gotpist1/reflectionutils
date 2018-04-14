package com.stridsberg.reflectionutils.repos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public interface MethodRepo {

	public Method getMethodByNameAndArgs(String methodName, Object...args);
	
	public Method getPrivateMethodByNameAndArgs(String methodName, Object...args);
	
	public List<Method> getMethods();
	
	public List<Method> getAllMethods();
	
	public List<Method> getAllMethodsVisiable();
	
	public <T> T invokeMethod(String methodName, Object...args);
	
	public <T> T invokePrivateMethod(String methodName, Object...args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException;
}
