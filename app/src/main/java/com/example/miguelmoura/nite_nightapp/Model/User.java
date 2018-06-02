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

    private final String DOT_SUBSTITUTE_STRING = "TERMINATIONDOT";

    public String getDOT_SUBSTITUTE_STRING() {
        return DOT_SUBSTITUTE_STRING;
    }

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
        unformatEmail();
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
        this.email = email.replace(".",DOT_SUBSTITUTE_STRING);
    }

    public void unformatEmail(){
        this.email = email.replace(DOT_SUBSTITUTE_STRING,".");
    }

    private String isEmailValid(){
        int indexOfAt = email.indexOf("@");
        int indexOfDot = email.indexOf(DOT_SUBSTITUTE_STRING);

        if(getEmail().length() < 8)
            return "Email too short";
        if(getEmail().length() > 100)
            return "Email too long";

        if(indexOfAt == -1)
            return "Email missing \"@\"";
        if(indexOfDot == -1)
            return "Email missing \".\"";

        if(indexOfAt > indexOfDot)
            return "Email \"@\" must be before \".\"";

        return "valid";
    }

    private String isBirthYearValid(){

        int bYear;
        try{
            bYear = Integer.parseInt(getBirthYear());
        }
        catch (NumberFormatException e){
            return "Birth year must be a number";
        }

        if(bYear < 1990)
            return "Birth Date must be greater than 1990";
        if(bYear > 2001)
            return "Birth Date must be less than 2001";
        else return "valid";
    }

    private String isPasswordValid(){
        if(getPassword().length() <= 8)
            return "Password too short";
        if(getPassword().length() >= 36)
            return "Password too long";
        else
            return "valid";
    }

    public String isValid(){
        String answer;
        if((answer = isEmailValid()) != "valid")
            return answer;
        if((answer = isPhoneNumberValid()) != "valid")
            return answer;
        if((answer = isBirthYearValid()) != "valid")
            return answer;
        if((answer = isPasswordValid()) != "valid")
            return answer;
        return "validUser";
    }

    private String isPhoneNumberValid() {
        int number;
        try{
            number = Integer.parseInt(getPhoneNumber());
        }
        catch (NumberFormatException e){
            return "Phone number must be a number";
        }
        if(number > 990000000)
            return "Phone number must be less than 990000000";
        if(number < 900000000)
            return "Phone number must be greater than 900000000";
        else
            return "valid";
    }
}