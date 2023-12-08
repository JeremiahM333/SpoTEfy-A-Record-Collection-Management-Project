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
    public List<Collection> getCollections() {
        List<Collection> retreivedCollections = collectionDao.getCollections();
        List<Collection> sortedCollections = new ArrayList<>();

        retreivedCollections.stream().filter(c -> c.isPublic()).forEach(c -> sortedCollections.add(c));

        return sortedCollections;
    }

    @GetMapping("/users/{userId}/collections")
    public List<Collection> getCollectionsByUserId(Principal principal) {
        //TO DO
        return null;
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


//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public Collection getCollection(@PathVariable int id,  Principal principal) {
//
//        Collection collection = collectionDao.getCollectionById(id);
//        if (collection == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection Not Found");
//        }
//
//        User loggedInUser = userDao.getUserByUsername(principal.getName());
//        if (!collection.isPublic() && !loggedInUser.getAuthorities().contains("ADMIN")) {
//            if (loggedInUser.getId() != collection.getUserId()) {
//                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The collection is private and you're not the owner");
//            }
//        }
//
//        return collection;
//    }
}
