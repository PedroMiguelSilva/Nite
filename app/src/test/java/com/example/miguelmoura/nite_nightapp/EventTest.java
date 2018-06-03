package com.example.miguelmoura.nite_nightapp;

import com.example.miguelmoura.nite_nightapp.Model.Event;

import org.junit.Test;

import static org.junit.Assert.*;


public class EventTest {

    @Test
    public void test_UpdateFinishedBefore(){
        Event event = new Event("1","1","23","21","desc","endhor","image","2","dsa","star","2000");
        assertEquals("true",event.getIsFinished());
    }

    @Test
    public void test_UpdateFinishedAfter(){
        Event event = new Event("1","1","23","21","desc","endhor","image","2","dsa","star","2030");
        assertEquals("true",event.getIsFinished());
    }

    @Test
    public void test_dataParse(){
        Event event = new Event("1","1","23","21","desc","endhor","image","2","dsa","star","2030");
        String date = event.getDate();
        assertEquals("21/2/2030",date);
    }
}