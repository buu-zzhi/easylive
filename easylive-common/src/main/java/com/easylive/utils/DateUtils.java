package com.easylive.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyy/MM/dd";

    public static String format(Date date, String patten) {
        return new SimpleDateFormat(patten).format(date);
    }

    public static Date parse(String date, String patten) {
        Date parseDate = null;
        try {
            parseDate = new SimpleDateFormat(patten).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parseDate;
    }
}
