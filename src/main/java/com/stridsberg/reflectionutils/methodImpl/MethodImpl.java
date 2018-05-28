package com.stridsberg.reflectionutils.methodImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.stridsberg.reflectionutils.helper.MethodHelper;
import com.stridsberg.reflectionutils.repos.MethodRepo;

public class MethodImpl extends MethodHelper implements MethodRepo {
	private Class<?> classHolder;
	
	public MethodImpl() {
		
	}

	public MethodImpl(Class<?> classHolder) {
		super(classHolder);
		this.classHolder = classHolder;
	}

	@Override
	public Method getMethodByNameAndArgs(String methodName, Class<?>... argsClasses) throws NoSuchMethodException, SecurityException {
		Method method = argsClasses != null ? classHolder.getDeclaredMethod(methodName,argsClasses) : classHolder.getDeclaredMethod(methodName);
		return method;
	}


	@Override
	public List<Method> getMethods() {
		return Arrays.asList(classHolder.getMethods()).stream()
				.filter(method -> method.toString().contains(classHolder.getName())).collect(Collectors.toList());
	}

	@Override
	public List<Method> getAllMethods() {
		return Arrays.asList(classHolder.getMethods());
	}

	@Override
	public List<Method> getAllMethodsVisiable() {
		return Arrays.asList(classHolder.getMethods()).stream().map(method -> {
			method.setAccessible(true);
			return method;
		}).collect(Collectors.toList());
		
	}

	@Override
	public <T> T invokeMethod(String methodName, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
		return invokeMethodByNameAndArgs(methodName, args);
	}

	@Override
	public <T> T invokeMethod(Method method, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
		return invokeMethodByMethod(method, args);
	}

}
