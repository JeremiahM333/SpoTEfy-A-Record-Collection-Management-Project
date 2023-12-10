package com.techelevator.dao;

import com.techelevator.model.Artist;

import java.util.List;

public interface ArtistDao {

    List<Artist> getArtistsByRecordId(int recordId);
}
