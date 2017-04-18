package com.example.nicha.finalproject;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Trinity on 4/18/2017.
 */

public class Utils {

    public static String convertTimestampToString(Timestamp poDate, String paFormat)
    {
        SimpleDateFormat voFormatter = new SimpleDateFormat(paFormat); // dd-MMM-yy

        return poDate == null? "" : voFormatter.format(poDate);
    }

    public static Timestamp convertStringToTimestamp(String paDate, String paFormat)
    {
        SimpleDateFormat voFormatter = new SimpleDateFormat(paFormat); // dd-MMM-yy

        java.util.Date voTmp;
        try
        {
            voTmp = voFormatter.parse(paDate);
        }
        catch (ParseException e)
        {
            return null;
        }

        return new Timestamp(voTmp.getTime());
    }
}
