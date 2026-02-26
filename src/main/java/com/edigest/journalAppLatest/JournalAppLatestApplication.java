package com.edigest.journalAppLatest;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class JournalAppLatestApplication {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Environment environment;

    @PostConstruct
    public void checkProps() {
        System.out.println("Mongo URI: " + environment.getProperty("spring.data.mongodb.uri"));
    }

    @Autowired
    private MongoDatabaseFactory factory;

    @PostConstruct
    public void checkFactory() {
        System.out.println("Factory DB: " + factory.getMongoDatabase().getName());
    }

    @PostConstruct
    public void printDb() {
        System.out.println("Connected DB: " + mongoTemplate.getDb().getName());
    }
    public static void main(String[] args) {
        SpringApplication.run(JournalAppLatestApplication.class, args);
    }

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory)
    {
     return new MongoTransactionManager(dbFactory);
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
