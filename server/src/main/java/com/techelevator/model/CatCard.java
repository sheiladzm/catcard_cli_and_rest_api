package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class CatCard {

	//match client side

	public Long catCardId;
	@NotEmpty
	public String name;
	@NotEmpty
	public String catFact;
	@NotEmpty
	public String imgUrl;
	@NotEmpty
	public String caption;


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

	public Long getCatCardId() {
		return catCardId;
	}

	public void setCatCardId(Long catCardId) {
		this.catCardId = catCardId;
	}
}
