package com.example.miguelmoura.nite_nightapp.Model;

public class Event {

    private String name;
    private String image;
    private String description;
    private String categoryId;
    private String clubId;
    private String contact;

    public Event(String name, String image, String description, String categoryId, String clubId, String contact) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.categoryId = categoryId;
        this.clubId = clubId;
        this.contact = contact;
    }

    public Event() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
