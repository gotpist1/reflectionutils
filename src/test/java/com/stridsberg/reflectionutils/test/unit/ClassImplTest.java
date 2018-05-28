package com.stridsberg.reflectionutils.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.stridsberg.reflectionutils.classImpl.ClassImpl;
import com.stridsberg.reflectionutils.methodImpl.MethodImpl;

public class ClassImplTest {

	TestClass<String> test = new TestClass<String>();
	
	ClassImpl classImpl = new ClassImpl(test.getClass());

	@Test
	public void testGetParameterizedClass() {
		Class<?> clazz = classImpl.getParameterizedClass();
		System.out.println(clazz.getTypeName());
	}
	
}
