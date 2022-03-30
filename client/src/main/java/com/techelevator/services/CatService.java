package com.techelevator.services;

import com.techelevator.model.Cat;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class CatService {

    //uses variables from model and houses CRUD methods to be used in the CLI
    //make http requests to the server
    //try catches will notify users network or client error codes if action fails

    private static final String API_BASE_URL = "http://localhost:8080/api/cards/";
    private RestTemplate restTemplate = new RestTemplate();

    private HttpEntity<Cat> makeEntity(Cat newCat) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  //the body of our request contains JSON

        // wrap the header and the body together in an HttpEntity object
        HttpEntity<Cat> entity = new HttpEntity<>(newCat, headers);

        return entity;

    }

    public Cat[] getAllCats(){

        Cat[] cats = null;

        try {
            cats = restTemplate.getForObject(API_BASE_URL, Cat[].class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        return cats;
    }

    public Cat getCat(long catCardId) {

        Cat cat = null;

        try {
            cat = restTemplate.getForObject(API_BASE_URL + catCardId, Cat.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        return cat;
    }

//    public Cat getCatCardRandomly(String random) {
//
//        Cat cat = null;
//
//        try {
//            cat = restTemplate.getForObject(API_BASE_URL + "/random", Cat.class);
//        } catch (RestClientResponseException e) {
//            System.out.println(e.getRawStatusCode());
//        } catch (ResourceAccessException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return cat;
//    }

    public CatPic getPicRandomly() throws RestClientResponseException {
        CatPic randomCatPic = restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
        return randomCatPic;
    }

    public CatFact getFactRandomly() throws RestClientResponseException {
        CatFact randomCatFact = restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
        return randomCatFact;
    }

    public Cat addCat(Cat newCat) {

        HttpEntity<Cat> entity = makeEntity(newCat);

        Cat cat = null;

        try {
            cat = restTemplate.postForObject(API_BASE_URL, entity, Cat.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        return cat;
    }

    public boolean update(Cat updatedCat) {

        HttpEntity<Cat> entity =  makeEntity(updatedCat);

        boolean success = false;

        try {
            restTemplate.put(API_BASE_URL + updatedCat.getCatCardId(), entity);
            success = true;
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        return success;
    }

    public boolean delete (Cat deletedCat) {

        HttpEntity<Cat> entity = makeEntity(deletedCat);

        boolean success = false;

        try {
            restTemplate.delete(API_BASE_URL + deletedCat.getCatCardId(), entity);
            success = true;
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }

        return success;
    }

}
