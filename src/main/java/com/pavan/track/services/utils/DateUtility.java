package com.pavan.track.services.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    private static final String PATTERN = "dd-MM-yyyy";

    public static LocalDate convertToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(PATTERN));
    }
}
