package com.example.miguelmoura.nite_nightapp.Model;

/**
 * Class to Represent a Category of an Event, it is represented with a name and an URL to a picture
 */
public class Category {
    /**
     * Name of the Category
     */
    private String name;

    /**
     * Empty Constructor
     */
    public Category() {
    }

    /**
     * String with the URL to the image associated with the Category
     */
    private String image;

    /**
     * Constructor that takes a string for the name and for the image of the Category
     * @param name
     *          Name of the Category
     * @param image
     *          URL to the picture of the Category
     */
    public Category(String name, String image){
        this.name = name;
        this.image = image;
    }

    /**
     * Get the name of the Category
     * @return Name of the Category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Category with a given parameter
     * @param name
     *          The Name of the category to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the URL for the image related to the Category
     * @return URL for the image related to the Category
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image of the Category to given String as argument
     * @param image
     *          URL to a picture elusive of the Category
     */
    public void setImage(String image) {
        this.image = image;
    }
}
