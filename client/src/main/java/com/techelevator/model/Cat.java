package com.techelevator.model;

public class Cat {

    public Long catCardId;
    public String name;
    public String catFact;
    public String imgUrl;
    public String caption;

    //generate getters and setters

    public Long getCatCardId() {
        return catCardId;
    }

    public void setCatCardId(Long catCardId) {
        this.catCardId = catCardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatFact() {
        return catFact;
    }

    public void setCatFact(String catFact) {
        this.catFact = catFact;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
