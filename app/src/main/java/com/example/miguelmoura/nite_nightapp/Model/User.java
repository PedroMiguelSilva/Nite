package com.example.miguelmoura.nite_nightapp.Model;

/**
 * Represents a User of the App
 * It can be used for the current user or for communication purposes
 * @version 1.0
 * @since 1.0
 * @author PedroMiguelSilva
 */
public class User {

    /**
     * UserName of the User
     */
    private String userName;

    /**
     * Email of the User
     */
    private String email;

    /**
     * Number of the phone of the user
     */
    private String phoneNumber;

    /**
     * Birth year of the User
     */
    private String birthYear;

    /**
     * Password of the User
     */
    private String password;

    /**
     * Constructor of User
     * @param userName
     *          Unique user name of the User
     * @param email
     *          Email of the User (unique)
     * @param phoneNumber
     *          Phone number of the User (unique)
     * @param birthYear
     *          Birth year of the User
     * @param password
     *          Password of the User
     */
    public User(String userName, String email, String phoneNumber, String birthYear, String password) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthYear = birthYear;
        this.password = password;
    }

    /**
     * Empty Constructor
     */
    public User() {
    }

    /**
     * Constructor with only E-mail.
     * @param email
     *          Email of the User
     */
    public User(String email) {
        this.email = email;
    }

    /**
     * Returns the user name of the User
     * @return UserName of the User
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the email of the User
     * @return Email of the User
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the phone number of the User
     * @return Phone number of the User
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the year of birth of the User
     * @return Year of Birth of User
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * Returns the password of the User
     * @return Password of the User
     */
    public String getPassword() {
        return password;
    }

    public void formatEmail(){
        this.email = email.replace(".","TERMINATIONDOT");
    }

    public void unformatEmail(){
        this.email = email.replace("TERMINATIONDOT",".");
    }
}