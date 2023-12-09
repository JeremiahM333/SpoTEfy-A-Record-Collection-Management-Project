package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CollectionController {

    private CollectionDao collectionDao;
    private UserDao userDao;

    public CollectionController(CollectionDao collectionDao, UserDao userDao) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
    }

    @GetMapping("/collections")
    public List<Collection> getPublicCollections() {
        return collectionDao.getPublicCollections();
    }

    @GetMapping("/users/{userId}/collections")
    public List<Collection> getCollectionsByUserId(@PathVariable int userId,  Principal principal) {
        User loggedInUser = userDao.getUserByEmailAddress(principal.getName());

        if (loggedInUser.getId() != userId && !loggedInUser.getAuthorities().contains("ROLE_ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You're not the owner of those collections");
        }

        return collectionDao.getCollectionsByUserId(userId);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/collections")
    public Collection createCollection(@RequestBody Collection collection) {

            Collection newCollection;
        try {
            newCollection = collectionDao.createCollection(collection);
            if (collection == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User registration failed.");
        }
        return newCollection;
    }
}
