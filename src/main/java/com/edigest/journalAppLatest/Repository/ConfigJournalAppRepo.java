package com.edigest.journalAppLatest.Repository;

import com.edigest.journalAppLatest.entity.ConfigJournalAppEntity;
import com.edigest.journalAppLatest.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepo extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
