package com.techelevator.dao;

import com.techelevator.model.Record;

import java.util.List;

public interface RecordDao {

    List<Record> getRecordsByCollectionId(int id);

    List<Record> getRecordsByUserId(int userId);

    Record getRecordById(int recordId);

    int getNumOfRecordsByUserId(int userId);

    Record createRecord(Record record);

    Record updateNotes(Record record);
}
