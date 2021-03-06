package com.example.miguelmoura.nite_nightapp.Model;

import java.net.Inet4Address;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents an Event/Party that has happened or will happen
 */
@SuppressWarnings("WeakerAccess")
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

    /**
     * Returns the Id of the Category
     * @return Id of the Category
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Empty constructor
     */
    public Event() {
    }

    /**
     * Return the String with the Contacts for the Event
     * @return Contacts for the Event
     */
    public String getContact() {
        return contact;
    }

    /**
     * Returns a String with the Day of the Event
     * @return Day of the Event
     */
    public String getDay() {
        return day;
    }

    /**
     * Returns a String with the description of the Event
     * @return Description of the Event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a String with the End hour of the Event
     * @return End hour of the Event
     */
    public String getEndHour() {
        return endHour;
    }

    /**
     * Returns a String with the URL of the image associated with the Event
     * @return Image of the Event
     */
    public String getImage() {
        return image;
    }

    /**
     * Returns a String with the month of the Event
     * @return Month of the Event
     */
    public String getMonth() {
        return month;
    }

    /**
     * Returns a String with the Name of the Event
     * @return Name of the Event
     */
    public String getName() {
        return name;
    }

    /**
     * Return a String with the Start hour of the Event
     * @return Start hour of the Event
     */
    public String getStartHour() {
        return startHour;
    }

    /**
     * Return a String with the Year of the Event
     * @return Year of the Event
     */
    public String getYear() {
        return year;
    }

    /**
     * Return a String with the Date formated as DD/MM/YYYY
     * @return Date as DD/MM/YYYY
     */
    public String getDate(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    /**
     * Returns the interval of the Event
     * @return Interval of the Event in "(startHour)h - (endHour)h"
     */
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
