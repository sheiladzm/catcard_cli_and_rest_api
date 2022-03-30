package com.techelevator.dao;

import com.techelevator.model.CatCard;

import java.util.List;

public interface CatCardDao {

	//houses abstract methods to touch database

	List<CatCard> list();

	CatCard get(long id);

	boolean add(CatCard cardToSave);

	boolean update(long id, CatCard card);

	boolean delete(long id);

}
