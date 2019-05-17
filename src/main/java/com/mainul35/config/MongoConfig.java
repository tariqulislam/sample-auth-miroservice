package com.mainul35.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.mainul35.model")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        MongoClient mongoClient = new MongoClient("localhost:27017");
        return mongoClient;
    }

    @Override
    protected String getDatabaseName() {
        return "auth_db";
    }
}
