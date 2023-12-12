package com.techelevator.dao;

import com.techelevator.model.Record;
import com.techelevator.model.Record2point0;

import java.util.List;

public interface RecordDao {

    List<Record2point0> getRecords();

    List<Record> getRecordsByCollectionId(int id);

    List<Record> getRecordsByUserId(int userId);

    Record getRecordById(int recordId);

    int getNumOfRecordsByUserId(int userId);

    Record createRecord(Record record);


}
