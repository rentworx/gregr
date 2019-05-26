package com.jgk.csv;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Class CSVReader
public class CSVReader
{
    public static void main(String[] args) throws Exception
    {

		//String csvPath = "\\Users\\jgkenned\\Documents\\Source Code - Research\\IdeaProjects\\Data\\";
        String csvPath = "G:\\winffs\\data\\bank interface\\";
		//String csvPath = "c:\\winffs\\data\\bank interface\\";
		
        //String csvFile = "download.CSV";
        //String csvFile = "downloadCORPACCTORIGINAL.csv";
		String csvFile = "download.csv";


// cvsSplitBy assigned to String type = to whatever is in quotes
        String cvsSplitBy = ",";

		
// Not sure of this but it looks like you are creating a new instance of ArrayList		
        ArrayList<Entity> records = new ArrayList<>();

// taking a shot on this one but you are opening the file and writing to it		
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath + csvFile));
             //BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath + csvFile + ".out")))
			 BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath + "brf.txt")))
        {

			int lineNum = 0; // used to skip the first line which is a header
			String line;
            while ((line = br.readLine()) != null )
// Grabbing the contents of the array and assigning them and splitting them with a comma
            {
            	if ( lineNum > 0 )
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
						throw new Exception("Illegal account designator");
					}
					e.setAccntDesignator(accntDesignator);

					try
					{
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy", Locale.ENGLISH);
						LocalDate date = LocalDate.parse(finandata[1], formatter);
						e.setPostedDate(date);
					}
					catch (DateTimeParseException ex)
					{
						throw new Exception("Improper date format");
					}


//assigning whatever is in the array at that position to the property setPostedDate
//Greg making changes at 3:57pm on 1/30/2018


					// Trying new route with Dateformatter 2/6/2017

//			mDateToBeFormatted = finandata[1];
//				e.setDateTimeFormatter.ISO_INSTANT.format(mDateToBeFormatted);

//


// Greg Added on 2/6/2018 at 11:43pm
					//DateTimeFormatter mDateToBeFormatted = mDateToBeFormatted.now();

					//e.setlocalDate = localDateTime.format(DateTimeFormatter.ISO_DATE);
					//localDate = DateTimeFormatter.ISO_LOCAL_DATE(finandata[1]);
					//localDate = DateTimeFormatter.LocalDate.parse((finandata[1]),DateTimeFormatter.ISO_LOCAL_DATE);
					//localDate = DateTimeFormatter.LocalDate.parse((finandata[1]),ISO_LOCAL_DATE);


					/**            DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

					 String formattedDate = formatter.format(finandata[1]);

					 e.setPostedDate=formattedDate;
					 */

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