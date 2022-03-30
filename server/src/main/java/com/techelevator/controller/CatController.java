package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//this controller will receive incoming web requests and will know what model or method to call to retrieve/manipulate data requested by the view/application

@RestController //indicate to Spring that this is a controller class
@RequestMapping("/api/cards") //handler method that returns, adds, updates, or deletes object with this base path
public class CatController {

    private CatCardDao cat;
    private CatFactService catFact;
    private CatPicService catPic;

    public CatController(CatCardDao cat, CatFactService catFact, CatPicService catPic) {
        this.cat = cat;
        this.catFact = catFact;
        this.catPic = catPic;
    }

    //value= aka path= corresponds to http request path, here it extends the base path specified above
    //method= specifies which http request method the handler method is used for (will be GET, PUT, POST, or DELETE)
    //handler method runs when assigned http request is received
    //the return will be in JSON format


    //this handler method finds a parameter of getIndividualCard() with the @PathVariable annotation, a long named id
    //an id number will replace {id} and is converted from string to a long value
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CatCard getIndividualCard(@PathVariable long id) {

        return cat.get(id);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CatCard> getAllCards() {

        return cat.list();

    }

//    @RequestMapping(value = "/random", method = RequestMethod.GET)
//    public CatCard makeNewCard() {
//        CatFact f = catFact.getFact();
//        CatPic p = catPic.getPic();
//        CatCard c = new CatCard();
//        c.setCatFact(f.getText());
//        c.setImgUrl(p.getFile());
//        return c;
//    }


    //use @ResponseStatus to return specific successful status code that corresponds to a specific method instead of default 200
        //for example @ResponseStatus(HttpStatus.NO_CONTENT) will display status code 204 for a successful DELETE request


    //instead of multiple @RequestParam, @RequestBody is used to have the incomingCard request body read and deserialized into an object
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveNewCard(@Valid @RequestBody CatCard incomingCard) {

        cat.add(incomingCard);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateExistingCard(@Valid @RequestBody CatCard changedCard, @PathVariable long id) {

        cat.update(id, changedCard);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteExistingCard(@PathVariable long id) {

        if(cat.get(id) != null) {
            cat.delete(id);
        }

    }
}