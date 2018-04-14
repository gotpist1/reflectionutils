package com.stridsberg.reflectionutils.test.unit;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.stridsberg.reflectionutils.methodImpl.MethodImpl;

public class MethodImplTest {

	MethodImpl methodImpl;;

	@Test
	public void testGetMethods() {
		List<Method> methods = methodImpl.getMethods();
		Assert.assertEquals(2, methods.size());
	}

	public class TestClass {
		public void getTest() {

		}

		public void getTest2() {

		}
	}

}
