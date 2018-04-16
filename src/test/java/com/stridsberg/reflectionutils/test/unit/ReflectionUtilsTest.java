package com.stridsberg.reflectionutils.test.unit;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.stridsberg.reflectionutils.util.ReflectionUtils;

public class ReflectionUtilsTest {

	@Test
	public void testGetMethods() {
		List<Method> methods = ReflectionUtils.getMethods(TestClass.class);
		Assert.assertEquals(2, methods.size());
	}
	
	@Test
	public void testInvokeMethod() {
		String actual = ReflectionUtils.invokeMethod(TestClass.class, "getString");
		Assert.assertEquals("Hello", actual);
	}
	
	@Test
	public void testInvokeListMethod() {
		List<String> actual = ReflectionUtils.invokeMethod(TestClass.class, "getList");
		Assert.assertEquals("Hello", actual.get(0));
	}


	@Test
	public void testInvokeMethodByMethod() {
		Method method = ReflectionUtils.getMethod(TestClass.class,"getString");
		String actual = ReflectionUtils.invokeMethod(method);
		Assert.assertEquals("Hello", actual);
	}
	

}
