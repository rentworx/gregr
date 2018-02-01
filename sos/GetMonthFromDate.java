//Code
//package com.jgk.csv;
import java.text.SimpleDateFormat;
import java.util.Date;

//
//The following example code demonstrates how to
//print out the Month from a Date object.
//
public class GetMonthFromDate {

    public static void main(String[] args) {

        Date now = finandata[1];
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM"); // two digit numerical represenation
        System.out.println(simpleDateformat.format(now));

        //simpleDateformat = new SimpleDateFormat("MMM"); // three digit abbreviation
       // System.out.println(simpleDateformat.format(now));

       // simpleDateformat = new SimpleDateFormat("MMMM"); // full month name
       // System.out.println(simpleDateformat.format(now));

    }

}