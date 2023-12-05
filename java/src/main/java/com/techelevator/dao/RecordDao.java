package com.techelevator.dao;

import com.techelevator.model.Record;

import java.util.List;

public interface RecordDao {

    List<Record> getRecordsByCollectionId();

    List<Record> getRecordsByUserId(int id);


}
