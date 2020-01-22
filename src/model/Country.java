package model;

public class Country implements Comparable<Country>{
    private String name;
    private int year;
    private long militarySpending;

    public Country(String name, int year, long militarySpending) {
        this.name = name;
        this.year = year;
        this.militarySpending = militarySpending;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public long getMilitarySpending() {
        return militarySpending;
    }

    @Override
    public int compareTo(Country country) {
        return (new Long(this.militarySpending - country.getMilitarySpending())).intValue();
    }
    
    
}
