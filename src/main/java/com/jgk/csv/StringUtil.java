package com.jgk.csv;

public final class StringUtil
{
    private StringUtil(){}

    public static String removeQuote(String s)
    {
        return s.replace("\"", "");
    }

    public static String removeSlash(String s)
    {
        return s.replace("\u002F", "");
    }

    public static String removeComma(String s)
    {
        return s.replace(",", "");
    }

    public static String removePeriod(String s)
    {
        return s.replace(".", "");
    }
}
