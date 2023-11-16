package org.example;

public record Person(String id,String name,DaysOfWeek favoriteDay) {
    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public DaysOfWeek favoriteDay() {
        return favoriteDay;
    }
}
