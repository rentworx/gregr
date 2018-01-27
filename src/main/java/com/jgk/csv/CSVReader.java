package com.jgk.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Clock;

public class CSVReader
{
    public static void main(String[] args)
    {
        String csvFile = "\\Users\\jgkenned\\Documents\\Source Code - Research\\IdeaProjects\\Data\\downloadCORPACCT.CSV";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
        {
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] finandata = line.split(cvsSplitBy);

                System.out.println("File contents [Account Designator= " + finandata[0] +
                        " , Posted Date= " + finandata[1] +
                        " , Serial Number= " + finandata[2] +
                        " , Description= " + StringUtil.removeQuote(finandata[3]) + "]");

                System.out.println(fixedRecord(finandata));
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static String fixedRecord(String[] s)
    {
        return String.format("%20s,%15s,%15s", s[0], s[1], s[2]);
    }

}