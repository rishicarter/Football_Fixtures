package UtilityClass;

/**
 * Created by rishi on 11/6/18.
 */

public class stripQuotes {
    public static String stripLeadingAndTrailingQuotes(String str)
    {
        if (str.startsWith("\""))
        {
            str = str.substring(1, str.length());
        }
        if (str.endsWith("\""))
        {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
