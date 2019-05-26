package com.jgk.csv;

public final class StringUtilComma
{
    private StringUtilComma(){}

    public static String removeComma(String s)
    {
        return s.replace(",", "");
    }
}
