package com.jgk.csv;

public final class StringUtil
{
    private StringUtil(){}

    public static String removeQuote(String s)
    {
        return s.replace("\"", "");
    }
}
