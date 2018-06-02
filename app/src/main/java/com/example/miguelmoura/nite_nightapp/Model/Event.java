package com.example.miguelmoura.nite_nightapp.Model;

import java.net.Inet4Address;
import java.util.Calendar;
import java.util.Date;

public class Event {

    private String categoryId;
    private String clubId;
    private String contact;
    private String day;
    private String description;
    private String endHour;
    private String image;
    private String month;
    private String name;
    private String startHour;
    private String year;
    private String isFinished;

    public String getIsFinished() {
        return isFinished;
    }

    public Event() {

    }

    public Event(String categoryId, String clubId, String contact, String day, String description, String endHour, String image, String month, String name, String startHour, String year) {
        this.categoryId = categoryId;
        this.clubId = clubId;
        this.contact = contact;
        this.day = day;
        this.description = description;
        this.endHour = endHour;
        this.image = image;
        this.month = month;
        this.name = name;
        this.startHour = startHour;
        this.year = year;
        this.isFinished = isFinished;

        isEventOver();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getClubId() {
        return clubId;
    }

    public String getContact() {
        return contact;
    }

    public String getDay() {
        return day;
    }

    public String getDescription() {
        return description;
    }

    public String getEndHour() {
        return endHour;
    }

    public String getImage() {
        return image;
    }

    public String getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }

    public String getStartHour() {
        return startHour;
    }

    public String getYear() {
        return year;
    }

    @SuppressWarnings("deprecation")
    void isEventOver(){
        Date currentTime = new Date();
        Date eventStart = new Date(Integer.parseInt(getYear()),Integer.parseInt(getMonth()),Integer.parseInt(getDay()));
        if(currentTime.before(eventStart))
            isFinished = "true";
        else
            isFinished = "false";
    }
}
