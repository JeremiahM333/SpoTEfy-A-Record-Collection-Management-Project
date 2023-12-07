package com.techelevator.controller;

import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Record;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class RecordController {

    private RecordDao recordDao;

    private UserDao userDao;

    public RecordController(RecordDao recordDao, UserDao userDao) {
        this.recordDao = recordDao;
        this.userDao = userDao;
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

    @GetMapping("records/{userId}")
    public List<Record> getRecordByUserId(@PathVariable int userId, Principal principal) {
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

}
