package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
