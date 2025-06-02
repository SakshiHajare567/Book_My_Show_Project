package com.example.Book_My_Show_May.EntryDtos;

public class TheaterEntryDto {
    private String name ;
    private String location ;
    private  int classicSetsCount ;
    private int premiumSetsCount ;

    public TheaterEntryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getClassicSetsCount() {
        return classicSetsCount;
    }

    public void setClassicSetsCount(int classicSetsCount) {
        this.classicSetsCount = classicSetsCount;
    }

    public int getPremiumSetsCount() {
        return premiumSetsCount;
    }

    public void setPremiumSetsCount(int premiumSetsCount) {
        this.premiumSetsCount = premiumSetsCount;
    }
}
