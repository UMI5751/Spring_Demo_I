package com.bowen.zhang.spring_demo_i.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDateString(String dateString) {
        Date date = null;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (Exception e) {
                date = new Date();
            }
        }else {
                date = new Date();
            }
        return date;

    }
}
