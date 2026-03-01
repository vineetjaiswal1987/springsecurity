package com.edigest.journalAppLatest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@NoArgsConstructor
@Document(collection = "config_journal_app")
@Data
public class ConfigJournalAppEntity {
    private  String key;
    private String value;
}
