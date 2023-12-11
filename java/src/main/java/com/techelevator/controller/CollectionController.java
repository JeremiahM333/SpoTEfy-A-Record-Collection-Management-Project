package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import com.techelevator.model.Record;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class CollectionController {

    private CollectionDao collectionDao;
    private UserDao userDao;

    private RecordDao recordDao;

    public CollectionController(CollectionDao collectionDao, UserDao userDao, RecordDao recordDao) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
        this.recordDao = recordDao;
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

    @GetMapping("/users/{userId}/collections/amount")
    public int getNumOfCollectionsByUserId(@PathVariable int userId) {
        return collectionDao.getNumOfCollectionsByUserId(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/records/{recordId}/collections")
    public int addRecordToCollection(@PathVariable int recordId, @RequestBody List<Integer> collectionIds, Principal principal) {
        User loggedInUser = userDao.getUserByEmailAddress(principal.getName());

        int rowsAffected = 0;

        for(Integer collectionId : collectionIds) {
            rowsAffected += collectionDao.addRecordToCollection(collectionId, recordId);
        }
        Record record = recordDao.getRecordById(recordId);
        if(rowsAffected != collectionIds.size()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add to Collections");
        }

        if (loggedInUser.getId() != record.getUserId() && !loggedInUser.getAuthorities().contains("ROLE_ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You're not the owner of this collections");
        }

        return rowsAffected;
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
