package com.techelevator.dao;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCatCardDao implements CatCardDao {

	//houses concrete methods to touch the database

	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());

	public JdbcCatCardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//called in methods below to transform database row into an object
	private CatCard mapRowToCard(SqlRowSet rs) {
		CatCard cc = new CatCard();
		cc.setName(rs.getString("name"));
		cc.setCatCardId(rs.getLong("id"));
		cc.setCatFact(rs.getString("fact"));
		cc.setImgUrl(rs.getString("img_url"));
		cc.setCaption(rs.getString("caption"));
		return cc;
	}

	//checks if card exists
	private boolean exists(long id) {
		return jdbcTemplate.queryForObject("select * from catcards where id = ?", new Object[]{id}, boolean.class);
	}

	//take all cat cards from the database and build a list
	@Override
	public List<CatCard> list() {
		List<CatCard> catCards = new ArrayList<>();
		String sql = "SELECT id, name, img_url, fact, caption FROM catcards ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			CatCard card = mapRowToCard(results);
			catCards.add(card);
		}
		return catCards;
	}

	//take a cat card individually depending on specified ID
	@Override
	public CatCard get(long id) {
		CatCard card = null;
		String sql = "SELECT id, name, img_url, fact, caption FROM catcards WHERE id = ? ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
		if(results.next()) {
			card = mapRowToCard(results);
		} else {
			throw new CatCardNotFoundException();
		}

		return card;
	}

//	this query uses API calls
//	@Override
//	public boolean update(long cardId, CatCard changedCard) {
//		String sql = "UPDATE catcards SET img_url = ?, fact = ?, caption = ? WHERE id = ? ";
//		return jdbcTemplate.update(sql, changedCard.getImgUrl(), changedCard.getCatFact(), changedCard.getCaption(), cardId) == 1;
//	}

	//updates a card in the database from specified ID
	@Override
	public boolean update(long cardId, CatCard changedCard) {
		String sql = "UPDATE catcards SET name = ?, img_url = ?, fact = ?, caption = ? WHERE id = ? ";
		return jdbcTemplate.update(sql, changedCard.getName(), changedCard.getImgUrl(), changedCard.getCatFact(), changedCard.getCaption(), cardId) == 1;
	}

	//deletes a card in the database from specified ID
	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM catcards WHERE id = ? ";
		return jdbcTemplate.update(sql, id) == 1;
	}

	//adds a card to the database
	@Override
	public boolean add(CatCard card) {
		String sql = "INSERT INTO catcards (id, name, img_url, fact, caption) VALUES (DEFAULT, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql,card.getName(),card.getImgUrl(),card.getCatFact(),card.getCaption()) == 1;
	}

}
