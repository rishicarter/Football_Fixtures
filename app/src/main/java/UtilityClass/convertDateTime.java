package UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rishi on 10/6/18.
 */

public class convertDateTime {

    private static String datestring;


    public static String[] convertDateTime(String datestr) throws ParseException {
        datestring = datestr;

        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sourceFormat.setTimeZone(utc);

        Date date = sourceFormat.parse(datestring);
        sourceFormat.setTimeZone(TimeZone.getDefault());

        return destFormat.format(date).split(" ");
    }

}
