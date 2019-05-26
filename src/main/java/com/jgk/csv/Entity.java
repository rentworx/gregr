package com.jgk.csv;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Entity
{
    //Account Designator,Posted Date,Serial Number,"Description",Amount,CR/DR
    private String accntDesignator;
    private LocalDate postedDate;
    private String serialNumber;
    private String description;
    private double amount;
    private String crdr;
	private int snlength;
	private int fivedigits = 5;
	private int fourdigits = 4;

    public String getAccntDesignator()
    {
        return accntDesignator;
    }

    public void setAccntDesignator(String accntDesignator)
    {
        this.accntDesignator = accntDesignator;
    }

    public LocalDate getPostedDate()
    {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate)
    {
        this.postedDate = postedDate;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getCrdr()
    {
        return crdr;
    }

    public void setCrdr(String crdr)
    {
        this.crdr = crdr;
    }

    public String toStringFixed()
    {
		
		//added on 5/2/2019 to determine string length
		//int snlength = serialNumber.length();
		//snlength = 10 - snlength;
		//serialNumber = String.format("%05d", serialNumber);
		
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
		
        String formattedPostedDate = getPostedDate().format(formatter);

        DecimalFormat numFormatter = new DecimalFormat("00000000000");
        String formattedAmount = numFormatter.format(100*getAmount());

        return String.format("%s%s%s%s+%s",
                getAccntDesignator(),
                getSerialNumber(),
				formattedPostedDate,
                formattedAmount,
                formattedPostedDate);
	}


    //}
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        //return Double.compare(entity.getAmount(), getAmount()) == 0 &&
        return Objects.equals(entity.getAmount(), getAmount()) &&
                Objects.equals(getAccntDesignator(), entity.getAccntDesignator()) &&
                Objects.equals(getPostedDate(), entity.getPostedDate()) &&
                Objects.equals(getSerialNumber(), entity.getSerialNumber()) &&
                Objects.equals(getDescription(), entity.getDescription()) &&
                Objects.equals(getCrdr(), entity.getCrdr());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getAccntDesignator(), getPostedDate(), getSerialNumber(), getDescription(), getAmount(), getCrdr());
		
		
    }

    @Override
    public String toString()
    {
        return "Entity{" +
                "accntDesignator='" + accntDesignator + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", crdr='" + crdr + '\'' +
                '}';
    }
}
