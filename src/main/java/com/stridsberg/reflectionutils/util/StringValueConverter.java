package com.stridsberg.reflectionutils.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.stridsberg.reflectionutils.enums.DateTimeFormats;
import com.stridsberg.reflectionutils.repos.ValueConverter;

public class StringValueConverter implements ValueConverter {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T convertValue(Class<?> convertTo, Object value) {

        String valueAsString = (String) value;
        if (convertTo.equals(String.class)) {
            return (T) valueAsString;
        } else if (convertTo.equals(Integer.class) || convertTo.equals(int.class)) {
            Integer integer = Integer.parseInt(valueAsString);
            return (T) integer;
        } else if (convertTo.equals(Double.class) || convertTo.equals(double.class)) {
            Double valueAsdouble = Double.parseDouble(valueAsString);
            return (T) valueAsdouble;
        } else if (convertTo.equals(Long.class) || convertTo.equals(long.class)) {
            Long valueAsLong = Long.parseLong(valueAsString);
            return (T) valueAsLong;
        } else if (convertTo.equals(Byte.class) || convertTo.equals(byte.class)) {
            Byte valueAsByte = Byte.parseByte(valueAsString);
            return (T) valueAsByte;
        } else if (convertTo.equals(Boolean.class) || convertTo.equals(boolean.class)) {
            Boolean valueAsBoolean = Boolean.parseBoolean(valueAsString);
            return (T) valueAsBoolean;
        } else if (convertTo.equals(Date.class)) {
            return (T) getDate(valueAsString);

        } else if (convertTo.equals(DateTime.class)) {
            return (T) getDateTime(valueAsString);
        }
        return null;
    }

    private DateTime getDateTime(String value) {
        DateTime date = null;
        try {
            date = DateTime.parse(value, DateTimeFormat.forPattern(getDateFormat(value)));
        } catch (Exception e) {

        }
        return date;
    }

    private Date getDate(String value) {
        SimpleDateFormat formatter = null;
        Date date = null;
        try {
            formatter = new SimpleDateFormat(getDateFormat(value));
            date = formatter.parse(value);
        } catch (Exception e) {

        }
        return date;
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
