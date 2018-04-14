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
		Assert.assertEquals(1, methods.size());
	}
	
	@Test
	public void testInvokeMethod() {
		String actual = ReflectionUtils.invokeMethod(TestClass.class, "getString");
		Assert.assertEquals("Hello", actual);
	}

	

}
