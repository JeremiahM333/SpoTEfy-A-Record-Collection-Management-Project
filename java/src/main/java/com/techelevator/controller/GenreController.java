package com.techelevator.controller;

import com.techelevator.dao.GenreDao;
import com.techelevator.model.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/records/{recordId}/genres")
    public List<Genre> createGenresForRecord(@PathVariable int recordId, @RequestBody List<String> genreNames) {
        return genreDao.createGenresForRecordId(recordId, genreNames);
    }
}
