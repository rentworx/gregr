package com.jgk.csv;

public final class StringUtilSlash
{
    private StringUtilSlash(){}

    public static String removeSlash(String s)
    {
        return s.replace("\u002F", "");
    }
}
