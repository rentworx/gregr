package com.jgk.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}