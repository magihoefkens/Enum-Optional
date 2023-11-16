package org.example;

public enum DaysOfWeek {
    MONDAY("Weekday"),
    TUESDAY("Weekday"),
    WEDNESDAY("Weekday"),
    THURSDAY("Weekday"),
    FRIDAY("Weekday"),
    SATURDAY("Weekend"),
    SUNDAY("Weekend");
    private final String dayType;
    DaysOfWeek(String dayType){
        this.dayType=dayType;
    }
    public String getDayType(){
        return dayType;
    }


}
