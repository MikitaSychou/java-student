package com.innowise.utils.validators;

import java.time.Year;
import java.util.Calendar;

public class Validators {


    public boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }

    public int getLastDayOfMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}

