// Java 8
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'");
        
        //default, ISO_LOCAL_DATE 
		
		//String dateInString = (finandata[1])
		
        LocalDateTime localDate = LocalDateTime.parse(dateInString, formatter);

        System.out.println();
        System.out.println("Get the Month Day and Year Fields");
        System.out.println("Month :: " + localDate.getMonth());
        System.out.println("Day   :: " + localDate.getDayOfMonth());
        System.out.println("Year  :: " + localDate.getYear());

        
        System.out.println();
        System.out.println("Write the Date using a different format");
        DateTimeFormatter newformatter = DateTimeFormatter.ofPattern("'Month' :: MMM, 'Day' :: dd, 'Year' :: yyyy");
        System.out.println(newformatter.format(localDate));

        System.out.println(localDate);
    }
}