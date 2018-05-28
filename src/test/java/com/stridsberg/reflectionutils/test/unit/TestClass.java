package com.stridsberg.reflectionutils.test.unit;

import java.util.ArrayList;
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

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getLongNum() {
        return longNum;
    }

    public void setLongNum(float longNum) {
        this.longNum = longNum;
    }


}
