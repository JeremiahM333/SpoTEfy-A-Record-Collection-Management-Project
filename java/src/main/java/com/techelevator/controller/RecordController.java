package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.Record;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/records")
@CrossOrigin
public class RecordController {

    private RecordDao recordDao;

    private UserDao userDao;

    private CollectionDao collectionDao;

    public RecordController(RecordDao recordDao, UserDao userDao, CollectionDao collectionDao) {
        this.recordDao = recordDao;
        this.userDao = userDao;
        this.collectionDao = collectionDao;
    }

    @GetMapping("records")
    public List<Record> getCurrentUserRecords(Principal principal) {
        User loggedInUser = userDao.getUserByEmailAddress(principal.getName());

        List<Record> records = recordDao.getRecordsByUserId(loggedInUser.getId());
        if (records == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Records Not Found");
        }

        return records;
    }

    @GetMapping("users/{userId}/records")
    public List<Record> getRecordsByUserId(@PathVariable int userId, Principal principal) {
        User loggedInUser = userDao.getUserByEmailAddress(principal.getName());

        List<Record> records = recordDao.getRecordsByUserId(userId);
        if (records == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Records Not Found");
        }

        if (loggedInUser.getId() != userId && !loggedInUser.getAuthorities().contains("ROLE_ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You're not the owner of those records");
        }

        return records;
    }

    @GetMapping("collections/{collectionId}/records")
    public List<Record> getRecordByCollectionId(@PathVariable int collectionId, Principal principal) {

        Collection collection = collectionDao.getCollectionById(collectionId);

        if (!collection.isPublic()) {
            User loggedInUser = userDao.getUserByEmailAddress(principal.getName());

            if (loggedInUser.getId() != collection.getUserId() || !loggedInUser.getAuthorities().contains("ROLE_ADMIN")) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "That collection id private and you are not the owner");
            }
        }

        List<Record> records = recordDao.getRecordsByCollectionId(collectionId);
        if (records == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Records Not Found");
        }

        return records;
    }

}
