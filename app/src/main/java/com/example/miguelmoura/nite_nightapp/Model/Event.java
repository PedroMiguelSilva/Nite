package com.example.miguelmoura.nite_nightapp.Model;

import java.net.Inet4Address;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents an Event/Party that has happened or will happen
 */
public class Event {

    /**
     * Id of the Category/Theme of the Event
     */
    private String categoryId;

    /**
     * Id of the Club/Bar/Establishment where the Event will take place
     */
    private String clubId;

    /**
     * String with the contacts of the Event manager
     */
    private String contact;

    /**
     * Day of the Start of the Event
     */
    private String day;

    /**
     * Description of the Event
     */
    private String description;

    /**
     * End hour of the Event
     */
    private String endHour;

    /**
     * URL to an image of the Club/Bar/Establishment where the Event will take place
     */
    private String image;

    /**
     * Month of the Start of the Event
     */
    private String month;

    /**
     * Name of the Event
     */
    private String name;

    /**
     * Start hour of the Event
     */
    private String startHour;

    /**
     * Year of the Start of the Event
     */
    private String year;

    /**
     * Either if the Event has already finished or not
     */
    private String isFinished;

    /**
     * Return if the Event has already taken place or not
     * @return "true" if the Event has already finished, "false" otherwise
     */
    public String getIsFinished() {
        return isFinished;
    }

    /**
     * Constructor for an Event (updates the value "isFinished" accordingly)
     * @param categoryId
     *          Id of the Category/Theme of the Event
     * @param clubId
     *          Id of the Club/Bar/Establishment where the Event will take place
     * @param contact
     *          String with the contacts of the Event manager
     * @param day
     *          Day of the Start of the Event
     * @param description
     *          Description of the Event
     * @param endHour
     *          End hour of the Event
     * @param image
     *          URL to an image of the Club/Bar/Establishment where the Event will take place
     * @param month
     *          Month of the Start of the Event
     * @param name
     *          Name of the Event
     * @param startHour
     *          Start hour of the Event
     * @param year
     *          Year of the Start of the Event
     */
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

        isEventOver();
    }

    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Empty constructor
     */
    public Event() {
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

    public String getDate(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    public String getTime(){
        return getStartHour() + "h - " + getEndHour() + "h";
    }

    /**
     * Updates the value of "isFinished" of Event
     */
    @SuppressWarnings("deprecation")
    private void isEventOver(){
        Date currentTime = new Date();
        Date eventStart = new Date(Integer.parseInt(getYear()),Integer.parseInt(getMonth()),Integer.parseInt(getDay()));
        if(currentTime.before(eventStart))
            isFinished = "true";
        else
            isFinished = "false";
    }
}
