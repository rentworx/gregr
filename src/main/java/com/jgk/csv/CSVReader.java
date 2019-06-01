package com.jgk.csv;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

/**
 * Main entry point of this application.
 */
public class CSVReader
{
    /**
     * Main entry point method.
     * Run like this: java -cp gregr-1.0.jar com.jgk.csv.CSVReader
     * @param args any arguments that you might pass.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        String csvInputPath = "\\Users\\jgkenned\\Data\\";
        String csvOutputPath = "\\Users\\jgkenned\\Data\\output\\";
        String file1_input = null;
        String file1_output = null;
        String file2_input = null;
        String file2_output = null;
        try (InputStream input = CSVReader.class.getClassLoader().getResourceAsStream("csvreader.properties"))
        {
            Properties prop = new Properties();
            prop.load(input);

            csvInputPath = prop.getProperty("data.path");
            csvOutputPath = prop.getProperty("data.path.output");
            file1_input = csvInputPath + prop.getProperty("corpacct.file");
            file1_output = csvOutputPath + prop.getProperty("corpacct.file.output");
            file2_input = csvInputPath + prop.getProperty("spiacct.file");
            file2_output = csvOutputPath + prop.getProperty("spiacct.file.output");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        //String csvPath = "G:\\winffs\\data\\bank interface\\";

        // cvsSplitBy assigned to String type = to whatever is in quotes
        String cvsSplitBy = ",";
        processFile(file1_input, file1_output, cvsSplitBy);
        processFile(file2_input, file2_output, cvsSplitBy);
    }

    /**
     * Processes 1 input file.
     * @param inputFile input file (reading from).
     * @param outputFile output file (writing to).
     * @param cvsSplitBy
     * @throws Exception when bad things happen.
     */
    private static void processFile(String inputFile, String outputFile, String cvsSplitBy) throws Exception
    {
        ArrayList<Entity> records = new ArrayList<>();

        System.out.println("\n\nProcessing file " + inputFile);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)))
        {
            int lineNum = 0; // used to skip the first line which is a header
            String line;
            while ((line = br.readLine()) != null)
            // Grabbing the contents of the array and assigning them and splitting them with a comma
            {
                if (lineNum > 0)
                {
                    // use comma as separator
                    String[] finandata = line.split(cvsSplitBy);

                    Entity e = new Entity();

                    //convert descriptive account designator to coded value
                    String accntDesignator = null;
                    if (finandata[0].trim().equalsIgnoreCase("Corporate Checking"))
                    {
                        accntDesignator = "  10000";
                    }
                    else if (finandata[0].trim().equalsIgnoreCase("Surepower Cash"))
                    {
                        accntDesignator = "SP100000";
                    }
                    //New Code on 1/25/2019 at 2:33pm for New Bank Account
                    else if (finandata[0].trim().equalsIgnoreCase("INSURANCENOW"))
                    {
                        //AcctDesignator needs to be changed to whatever it actually is
                        accntDesignator = "SP1000000";
                    }
                    else
                    {
                        System.out.println("Line # " + lineNum);
                        throw new Exception("Illegal account designator");
                    }
                    e.setAccntDesignator(accntDesignator);

                    try
                    {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy", Locale.ENGLISH);
                        LocalDate date = LocalDate.parse(finandata[1], formatter);
                        e.setPostedDate(date);
                    }
                    catch (DateTimeParseException ex)
                    {
                        System.out.println("Line # " + lineNum);
                        System.out.println("finandata[1] " + finandata[1]);
                        throw new Exception("Improper date format");
                    }

                    e.setSerialNumber(finandata[2]);
                    e.setDescription(finandata[3]);
                    e.setAmount(Double.parseDouble(finandata[4]));
                    e.setCrdr(finandata[5]);

                    records.add(e);

                    //String isItInThere = "DDA CHECK #";
                    if (e.getDescription().contains("DDA CHECK #"))
                    {
                        // now write data to a new file in fixed len
                        writer.write(e.toStringFixed());
                        System.out.println(e.toStringFixed());
                        writer.newLine();
                    }
                }
                lineNum++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
