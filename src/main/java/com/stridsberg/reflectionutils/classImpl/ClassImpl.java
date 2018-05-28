package com.stridsberg.reflectionutils.classImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.stridsberg.reflectionutils.repos.ClassRepo;
import com.stridsberg.reflectionutils.repos.ValueConverter;
import com.stridsberg.reflectionutils.util.ReflectionHelper;

public class ClassImpl extends ReflectionHelper implements ClassRepo {

    private Class<?> classHolder;

    public ClassImpl(Class<?> classHolder) {
        super(classHolder);
        this.classHolder = classHolder;
    }

    @Override
    public Class<?> getParameterizedClass() {
        // TODO Auto-generated method stub
        return getTypeParameterizedClass();
    }

    @Override
    public <T> T instantiateHiddenConstructor(Object... params) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T populateBeanFromMap(Map<String, ? extends Object> beanMap) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T populateBeanFromMap(Map<String, String> beanMap, ValueConverter converter) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        final Object bean = classHolder.getDeclaredConstructor().newInstance();
        Map<String, Method> setters = Arrays.asList(bean.getClass().getMethods()).stream()
                .filter(method -> method.getName().contains("set")).collect(Collectors.toMap(this::getParamNameFromMethod, (m) -> m));
        beanMap.forEach((k, v) -> {
            Method method = setters.get(k);
            try {
                if (v != null) {
                    Object value = converter.convertValue(method.getParameterTypes()[0], v);
                    method.invoke(bean, value);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        return (T) bean;
    }

    private String getParamNameFromMethod(Method method) {
        return method.getName().substring(3).substring(0, 1).toLowerCase() + method.getName().substring(4);
    }

}
