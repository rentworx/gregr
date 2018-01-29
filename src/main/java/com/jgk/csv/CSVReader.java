//Code
package com.jgk.csv;

// imports
import java.io.*;
// date/time imports
import java.time.Clock;

// array imports
import java.util.ArrayList;

// Class CSVReader
public class CSVReader
{
    public static void main(String[] args)
    {

//  csvPath assigned to a String type
        String csvPath = "\\data\\JavaData\\";
		
//  csvFile assiged to a String type
        String csvFile = "downloadCA.CSV";
//  line assigned to null
        String line;

// cvsSplitBy assigned to String type = to whatever is in quotes
        String cvsSplitBy = ",";
		//String cvsSplitBy = null;

// Greg Added on 1/28/2018 at 8:37pm
		String maccountDesignator="";
		
		
		
// Not sure of this but it looks like you are creating a new instance of ArrayList		
        ArrayList<Entity> records = new ArrayList<>();


// taking a shot on this one but you are opening the file and writing to it		
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath + csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath + csvFile + ".fix")))
        {
// Initializing maxWidethOfDesc to 0
            int maxWidthOfDesc = 0;

// creating a loop and reading the lines from csvFile and that not null
            while ((line = br.readLine()) != null)
// Grabbing the contents of the array and assigning them and splitting them with a comma
            {
                // use comma as separator
                String[] finandata = line.split(cvsSplitBy);

// creating a new instance of Entity called "e"  ????
                Entity e = new Entity();
				
				
				
//assigning whatever is in the array at that position to the property setAccntDesignator				
                e.setAccntDesignator(finandata[0]);

				// Greg Added on 1/28/2018 at 8:37pm
				if (finandata[0].indexOf("Corporate Checking")>1);{
				
				maccountDesignator = "  10000";
				e.setAccntDesignator(maccountDesignator);
				
				}	

//assigning whatever is in the array at that position to the property setPostedDate
				e.setPostedDate(finandata[1]);
//assigning whatever is ....
                e.setSerialNumber(finandata[2]);
//assigning whatever is ....
                e.setDescription(StringUtil.removeQuote(finandata[3]));
                e.setAmount(Double.valueOf(finandata[4]));
                e.setCrdr(finandata[5]);
 
 
//writing out "e"
			
                records.add(e);

			//String isItInThere = "DDA CHECK #";
				String isItInThere = finandata[3];
				
			if  ( isItInThere.contains("DDA CHECK #") )
			
			
			{
			//not sure about it looks like you are adding a record called "e"
		
               writer.write(e.toStringFixed());

//writing out a CR "newLine"
                writer.newLine();
			}

			
//printing to file "e"
			
			
			System.out.println(e);
				
            System.out.println(e.toStringFixed());
						
			
				
// create a integer var lenDescr  passing arg finandata and it's length ????
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


}