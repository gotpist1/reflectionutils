package com.stridsberg.reflectionutils.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.stridsberg.reflectionutils.classImpl.ClassImpl;
import com.stridsberg.reflectionutils.methodImpl.MethodImpl;
import com.stridsberg.reflectionutils.repos.ValueConverter;

public class ReflectionUtils<T> {

    public static <T> List<Method> getMethods(Class<?> classHolder) {
        return new MethodImpl(classHolder).getMethods();
    }

    public static <T> T invokeMethod(Class<?> classHolder, String methodName, Object... args) {
        T t = null;
        try {
            t = new MethodImpl(classHolder).invokeMethod(methodName, args);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T invokeMethod(Method method, Object... args) {
        T t = null;
        try {
            t = new MethodImpl(method.getDeclaringClass()).invokeMethod(method, args);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    public static Method getMethod(Class<?> classHolder, String methodName, Class<?>... argsClasses) {
        Method method = null;
        try {
            method = new MethodImpl(classHolder).getMethodByNameAndArgs(methodName, argsClasses);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return method;
    }

    public static <T> T populateBeanFromStringKeyValueMap(Class<?> classHolder, Map<String, String> beanMap, ValueConverter converter) {
        try {
            return new ClassImpl(classHolder).populateBeanFromMap(beanMap, converter);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
