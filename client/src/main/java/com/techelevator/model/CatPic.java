package com.techelevator.model;

public class CatPic {

    private String file;

    //parses JSON object into string to be used for automatically generating this data when adding a new card
    public String getFile() {
        return this.file;
    }
    public void setFile(String file) {
        this.file = file;
    }

}
