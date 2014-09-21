package com.bangsapabbi.api.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    private DateUtil() {
    }

    public static String getFromDate(final Date date, final String format) {
        return new SimpleDateFormat(format, Locale.getDefault()).format(date);
    }


    public static String getFromDate(final Date date) {
        return getFromDate(date, DATE_FORMAT);
    }
}