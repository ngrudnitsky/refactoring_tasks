package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*It’s better not to use the boolean value in the changeToMidnight method,
	but to divide it into two different methods from the very beginning:
	changeToMidnightDown and changeToMidnightUp*/

    public Date changeToMidnight(Date date, boolean up) {
        return up ? changeToMidnightUp(date) : changeToMidnightDown(date);
    }

    private Date changeToMidnightDown(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    private Date changeToMidnightUp(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    private Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}
