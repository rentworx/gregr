package com.jgk.csv;

public final class StringUtilPeriod
{
    private StringUtilPeriod(){}

    public static String removePeriod(String s)
    {
        return s.replace(".", "");
    }
}
