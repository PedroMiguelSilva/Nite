package com.example.miguelmoura.nite_nightapp.Session;


import com.example.miguelmoura.nite_nightapp.Model.User;

public class Session {
    public static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Session.currentUser = currentUser;
    }
}
