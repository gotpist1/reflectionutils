package com.stridsberg.reflectionutils.repos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public interface MethodRepo {

	/**
	 * Get method from method name and it's parameter classes
	 * 
	 * @param methodName
	 * @param argsClasses
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public Method getMethodByNameAndArgs(String methodName, Class<?>... argsClasses)
			throws NoSuchMethodException, SecurityException;

	/**
	 * @return List of methods in the class (none of its superclass methods will be in the list)
	 */
	public List<Method> getMethods();

	/**
	 * @return List of ALL methods. (Superclass methiods included)
	 */
	public List<Method> getAllMethods();

	/**
	 * @return List of all methods with visibillity set to true
	 */
	public List<Method> getAllMethodsVisiable();

	/**
	 * Invoke Method by specifying name of method and all tha args needed for the method (or none if none)
	 * 
	 * @param methodName
	 * @param args
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public <T> T invokeMethod(String methodName, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException ;

	/**
	 * Invoke Method by specifying the Method and it's args (or none if none)
	 * 
	 * @param method
	 * @param args
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public <T> T invokeMethod(Method method, Object... args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException;

}
