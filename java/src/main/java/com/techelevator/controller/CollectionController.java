package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/collection")
@CrossOrigin
public class CollectionController {

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Collection getCollection(@PathVariable int id, Principal principal) {
//        User loggedInUser = userDao.getUserByUsername(principal.getName());
        Collection collection = CollectionDao.getCollectionById(id);
//        if (collection == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
//        }
//        if (loggedInUser.getId() != account.getUserId()) {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not your account");
//        }
        return collection;
    }


}
