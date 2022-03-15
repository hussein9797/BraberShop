package com.Basil.BraberShop.Helper;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    public static Date addDaysWithGetFirstHour(Date date, int days) {
        int year = Integer.parseInt(toString(date, "yyyy"));
        int month = Integer.parseInt(toString(date, "MM"));
        int day = Integer.parseInt(toString(date, "dd")) + days;
        return toDate(year + "-" + month + "-" + day);
    }

    public static long daysBetweenWithoutTime(Date start, Date end) {
        long diff = end.getTime() - start.getTime();
        float days = (float) diff / (float) (1000 * 60 * 60 * 24);
        double result = Math.ceil(days);
        return (long) result;
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    static public String convertDateToString(Date date) {
        return toString(date, "YYYY-MM-dd' 'HH:mm:ss");
    }

    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date setTime(Date date, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    static public Date toDate(String dateString) {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return isoFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    static public String toDateTimeString(Date date) {
        return toString(date, "YYYY-MM-dd'T'HH:mm:ss.SSSZ");
    }

    static public String toDateString(Date date) {
        return toString(date, "yyyy-MM-dd");
    }

    static public String toString(Date date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        formater.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formater.format(date);
    }

    static public String getSimpleFormat(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String getFormattedStartOfDay(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(getStartOfDay(date));
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }



    public static Date ConvertStringToDate(String dateAsString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String dateStartInString = dateAsString;
        Date date = formatter.parse(dateStartInString);
        return date;
    }

    public static String toPersonalAnalyzerDateString(Date date){
      return toString(date,"yyyy-MM");
    }
}
