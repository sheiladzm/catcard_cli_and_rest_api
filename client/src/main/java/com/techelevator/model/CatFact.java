package com.techelevator.model;

public class CatFact {
    private String text;

    //parses JSON object into string to be used for automatically generating this data when adding a new card
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
