package com.stridsberg.reflectionutils.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ReflectionHelper {
    Class<?> classOfMethod;

    public ReflectionHelper(Class<?> classOfMethod) {
        this.classOfMethod = classOfMethod;
    }

    @SuppressWarnings("unchecked")
    protected <T> T invokeMethodHelper(String methodName, Object... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
        Object object = null;
        Method[] methods = classOfMethod.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase(methodName)) {
                method.setAccessible(true);
                if (shouldInvokeMethod(method, args)) {
                	if(args != null && args.length > 0) {
                		object = method.invoke(classOfMethod.getDeclaredConstructor().newInstance(), args);
                	}else {
                		object = method.invoke(classOfMethod.getDeclaredConstructor().newInstance());
                	}
                    
                    break;
                }

            }
        }
        return (T) object;
    }

    private boolean shouldInvokeMethod(Method method, Object... args) {
        if (method.getParameterTypes().length == args.length) {
            List<Class<?>> classes = Arrays.asList(method.getParameterTypes());
            List<Class<?>> parameterClasses = Arrays.asList(args).stream().map(parameter -> parameter.getClass())
                    .map(clazz -> getPrimitiveClass(clazz)).collect(Collectors.toList());
            if (!classes.containsAll(parameterClasses))
                return false;
        } else {
            return false;
        }
        return true;
    }

    private Class<?> getPrimitiveClass(Class<?> clazz) {
        if (clazz.equals(Integer.class)) {
            return Integer.TYPE;
        } else if (clazz.equals(Float.class)) {
            return Float.TYPE;
        } else {
            return clazz;
        }
    }
}
