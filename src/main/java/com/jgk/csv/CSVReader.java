package com.jgk.csv;

import java.io.*;
import java.util.ArrayList;

public class CSVReader
{
    public static void main(String[] args)
    {
        String csvPath = "\\Users\\jgkenned\\Documents\\Source Code - Research\\IdeaProjects\\Data\\";
        String csvFile = "downloadCORPACCT.CSV";
        String line;
        String cvsSplitBy = ",";

        ArrayList<Entity> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath + csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath + csvFile + ".fix")))
        {
            int maxWidthOfDesc = 0;
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] finandata = line.split(cvsSplitBy);

                Entity e = new Entity();
                e.setAccntDesignator(finandata[0]);
                e.setPostedDate(finandata[1]);
                e.setSerialNumber(finandata[2]);
                e.setDescription(StringUtil.removeQuote(finandata[3]));
                e.setAmmount(Double.valueOf(finandata[4]));
                e.setCrdr(finandata[5]);
                records.add(e);
                writer.write(e.toStringFixed());
                writer.newLine();

                System.out.println(e);
                System.out.println(e.toStringFixed());

                int lenDescr = StringUtil.removeQuote(finandata[3]).length();
                if ( lenDescr > maxWidthOfDesc )
                {
                    maxWidthOfDesc = lenDescr;
                }

            }
            System.out.println("max len of description = " + maxWidthOfDesc);

            // now write data to a new file in fixed len

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static String fixedRecord(String[] s)
    {
        return String.format("%20s,%15s,%15s,%100s,%15s,%4s", s[0], s[1], s[2], StringUtil.removeQuote(s[3]), s[4], s[5]);
    }

}