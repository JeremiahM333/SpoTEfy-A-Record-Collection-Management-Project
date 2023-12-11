package com.techelevator.controller;

import com.techelevator.dao.ArtistDao;
import com.techelevator.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ArtistController {

    private ArtistDao artistDao;

    public ArtistController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @GetMapping("/records/{recordId}/artists")
    public List<Artist> getGenresByRecordId(@PathVariable int recordId) {
        return artistDao.getArtistsByRecordId(recordId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/records/{recordId}/artists")
    public List<Artist> createArtistsForRecord(@PathVariable int recordId, @RequestBody List<String> artistNames) {
        return artistDao.createArtistsForRecordId(recordId, artistNames);
    }
}
