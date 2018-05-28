package com.stridsberg.reflectionutils.test.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass<T> {

	private String one;

	private int number;

	private float longNum;

	public void getTest() {

	}

	public void getTest2() {

	}

	private String getString() {
		return "Hello";
	}
	
	private String getString(String arg) {
		return "Hello "+arg;
	}

	private List<String> getList() {
		List<String> t = new ArrayList<>();
		t.add("Hello");
		return t;
	}
}
