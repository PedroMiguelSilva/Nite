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

    private String DOT_SUBSTITUTE_STRING = "TERMINATIONDOT";

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

        DOT_SUBSTITUTE_STRING = "TERMINATIONDOT";
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
        DOT_SUBSTITUTE_STRING = "TERMINATIONDOT";
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
    private String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the year of birth of the User
     * @return Year of Birth of User
     */
    private String getBirthYear() {
        return birthYear;
    }

    /**
     * Returns the password of the User
     * @return Password of the User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Formats the Email of the User to be accepted as a FireBase Real-time Database key
     */
    public void formatEmail(){
        this.email = email.replace(".",DOT_SUBSTITUTE_STRING);
    }

    /**
     * Unformats the Email of the User for display purposes
     */
    public void unformatEmail(){
        this.email = email.replace(DOT_SUBSTITUTE_STRING,".");
    }

    /**
     * Checks if an Email is Valid and returns a String accordingly
     * @return String with the message of Error or the String "valid" if valid
     */
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

    /**
     * Checks if the birth year is valid
     * @return String with the message of Error or the String "valid" if valid
     */
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

    /**
     * Checks if the password is valid
     * @return String with the message of Error or the String "valid" if valid
     */
    private String isPasswordValid(){
        if(getPassword().length() <= 8)
            return "Password too short";
        if(getPassword().length() >= 36)
            return "Password too long";
        else
            return "valid";
    }

    /**
     * Checks if the Information of the User is valid in order to accept it as a new User
     * @return "validUser" if the Information is valid, Error String otherwise
     */
    public String isValid(){
        String answer;
        if(!(answer = isEmailValid()).equals("valid"))
            return answer;
        if(!(answer = isPhoneNumberValid()).equals("valid"))
            return answer;
        if(!(answer = isBirthYearValid()).equals("valid"))
            return answer;
        if(!(answer = isPasswordValid()).equals("valid"))
            return answer;
        return "validUser";
    }

    /**
     * Checks if the Phone Number is valid
     * @return String with the message of Error or the String "valid" if valid
     */
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