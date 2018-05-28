package com.stridsberg.reflectionutils.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.stridsberg.reflectionutils.methodImpl.MethodImpl;

public class MethodImplTest {

	MethodImpl methodImpl = new MethodImpl(TestClass.class);

	@Test
	public void testGetMethods() {
		List<Method> methods = methodImpl.getMethods();
		Assert.assertEquals(2, methods.size());
	}
	
	@Test
	public void testInvokeMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Method method = methodImpl.getMethodByNameAndArgs("getString");
		String actual = methodImpl.invokeMethod(method);
		assertEquals("Hello",actual);
	}
	
	@Test
	public void testInvokeOverloadingMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Method method = methodImpl.getMethodByNameAndArgs("getString", String.class);
		String actual = methodImpl.invokeMethod(method, "World");
		assertEquals("Hello World",actual);
	}
	
	@Test
	public void testInvokeMethodbyStringName() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		String actual = methodImpl.invokeMethod("getString");
		assertEquals("Hello",actual);
	}

}
