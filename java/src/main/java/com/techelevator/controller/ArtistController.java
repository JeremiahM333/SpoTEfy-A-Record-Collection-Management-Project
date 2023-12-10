package com.techelevator.controller;

import com.techelevator.dao.ArtistDao;
import com.techelevator.model.Artist;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
