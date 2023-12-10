package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.GenreDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Genre;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GenreController {

    private GenreDao genreDao;

    public GenreController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @GetMapping("/records/{recordId}/genres")
    public List<Genre> getGenresByRecordId(@PathVariable int recordId) {
        return genreDao.getGenresByRecordId(recordId);
    }
}
