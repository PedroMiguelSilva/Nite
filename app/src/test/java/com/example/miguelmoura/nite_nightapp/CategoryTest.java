package com.example.miguelmoura.nite_nightapp;

import com.example.miguelmoura.nite_nightapp.Model.Category;
import com.example.miguelmoura.nite_nightapp.Model.Event;

import org.junit.Test;

import static org.junit.Assert.*;


public class CategoryTest {

    @Test
    public void checkConstructor(){
        Category cat = new Category("name","image");
        assertEquals("name",cat.getName());
        assertEquals("image",cat.getImage());
        cat.setName("outronome");
        assertEquals("outronome",cat.getName());
        cat.setImage("outraimagem");
        assertEquals("outraimagem",cat.getImage());
    }
}