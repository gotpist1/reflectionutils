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
		// TODO Auto-generated method stub
		Method method = argsClasses != null ? classHolder.getDeclaredMethod(methodName,argsClasses) : classHolder.getDeclaredMethod(methodName);
		return method;
	}

	@Override
	public Method getPrivateMethodByNameAndArgs(String methodName, Class<?>... argsClasses) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Method method = argsClasses != null ? classHolder.getDeclaredMethod(methodName,argsClasses) : classHolder.getDeclaredMethod(methodName);
		method.setAccessible(true);
		return method;
	}

	@Override
	public List<Method> getMethods() {
		return Arrays.asList(classHolder.getMethods()).stream()
				.filter(method -> method.toString().contains(classHolder.getName())).collect(Collectors.toList());
	}

	@Override
	public List<Method> getAllMethods() {
		// TODO Auto-generated method stub
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
	public <T> T invokeMethod(String methodName, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T invokeMethodByName(String methodName, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return invokeMethodByNameAndArgs(methodName, args);
	}

	@Override
	public <T> T invokeMethod(Method method, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return invokeMethodByMethod(method, args);
	}

}
