package com.example.miguelmoura.nite_nightapp.Model;

public class Event {
    private String name, image, description, menuId;

    public Event(String name, String image, String description, String menuId) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.menuId = menuId;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
