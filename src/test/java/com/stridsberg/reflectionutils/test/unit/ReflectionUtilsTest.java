package com.stridsberg.reflectionutils.test.unit;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Test;

import com.stridsberg.reflectionutils.enums.DateTimeFormats;
import com.stridsberg.reflectionutils.util.ReflectionUtils;
import com.stridsberg.reflectionutils.util.StringValueConverter;

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
        Method method = ReflectionUtils.getMethod(TestClass.class, "getString");
        String actual = ReflectionUtils.invokeMethod(method);
        Assert.assertEquals("Hello", actual);
    }

    @Test
    public void testPopulateBeanFromMap() {
        Map<String, String> beanMap = new HashMap<>();
        beanMap.put("id", "1");
        beanMap.put("geometry",
                "POLYGON((11.848930547580721 57.72472352772318,11.849595735416415 57.72480946359651,11.849939058170321 57.72415634584084,11.849188039646151 57.72405322090712,11.848930547580721 57.72472352772318)) |");
        beanMap.put("zoneId", "666");
        beanMap.put("name", "VAK_666");
        beanMap.put("version", "1");
        beanMap.put("country", "SV");
        beanMap.put("nationalIdentifier", "SVV");
        beanMap.put("state", "1");
        beanMap.put("state2", "666");
        beanMap.put("updateTime", "2018-05-23 09:44:03");
        Zone zone = ReflectionUtils.populateBeanFromStringKeyValueMap(Zone.class, beanMap, new StringValueConverter());
        Assert.assertNotNull(zone);
    }

    @Test
    public void testDateTime() throws Exception {
        DateTime date = DateTime.parse("2018-05-23 09:44:03", DateTimeFormat.forPattern(getDateFormat("2018-05-23 09:44:03")));
        System.out.println(date.toString());
    }

    private String getDateFormat(String value) throws Exception {
        String longDatePattern = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        String shortDatePattern = "\\d{4}-\\d{2}-\\d{2}";
        if (value.matches(longDatePattern)) {
            return DateTimeFormats.LONG_DATE_AND_TIME.getFormat();
        } else if (value.matches(shortDatePattern)) {
            return DateTimeFormats.SHORT_DATE_NO_TIME.getFormat();
        } else {
            throw new Exception("Not a parsable Date String at this time!");
        }
    }


}
