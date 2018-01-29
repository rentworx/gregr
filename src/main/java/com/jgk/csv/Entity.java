package com.jgk.csv;

import java.util.Objects;

public class Entity
{
    //Account Designator,Posted Date,Serial Number,"Description",Amount,CR/DR
    private String accntDesignator;
    private String postedDate;
    private String serialNumber;
    private String description;
    private double amount;
    private String crdr;

    public String getAccntDesignator()
    {
        return accntDesignator;
    }

    public void setAccntDesignator(String accntDesignator)
    {
        this.accntDesignator = accntDesignator;
    }

    public String getPostedDate()
    {
        return postedDate;
    }

    public void setPostedDate(String postedDate)
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
        return String.format("%2s,%1s,%1s,%1s,%1s,%1s",
                getAccntDesignator(),
                getPostedDate(),
                getSerialNumber(),
                getDescription(),
                getAmount(),
                getCrdr());
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return Double.compare(entity.getAmount(), getAmount()) == 0 &&
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
