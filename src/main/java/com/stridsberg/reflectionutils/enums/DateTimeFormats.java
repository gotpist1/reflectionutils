package com.stridsberg.reflectionutils.enums;

public enum DateTimeFormats {
    LONG_DATE_AND_TIME("yyyy-MM-dd hh:mm:ss"), SHORT_DATE_NO_TIME("yyyy-MM-dd");

    private String format;

    DateTimeFormats(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}
