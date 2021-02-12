package com.team4.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static String formatDate(String rawDate) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date date = dateFormat.parse(rawDate);
            DateFormat formatter = new  SimpleDateFormat("dd MMM yy", Locale.getDefault());
            return formatter.format(date);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return null;
    }

    public static Date getDate(String rawDate) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return dateFormat.parse(rawDate);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return null;
    }
}
