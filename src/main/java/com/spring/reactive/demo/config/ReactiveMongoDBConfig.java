package com.spring.reactive.demo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.spring.reactive.demo")
class ReactiveMongoDBConfig extends AbstractReactiveMongoConfiguration {

    @Value("${reactive.mongodb.name: reactive_mongodb}")
    private String reactiveMongoDBName;

    @Value("${reactive.mongodb.uri}")
    private String mongoURI;

//    @Value("${reactive.mongodb.username}")
//    private String reactiveMongoDBUsername;
//
//    @Value("${reactive.mongodb.password}")
//    private String reactiveMongoDBPassword;

//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create(mongoURI);
//    }

    @Override
    protected String getDatabaseName() {
        return reactiveMongoDBName;
    }

    @Override
    public MongoClient reactiveMongoClient() {

//        MongoCredential mongoCredential = MongoCredential.createCredential(reactiveMongoDBUsername, reactiveMongoDBName, reactiveMongoDBPassword.toCharArray());
//
//        ConnectionString connectionString = new ConnectionString(mongoURI);
//
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .credential(mongoCredential)
//                .build();

         return MongoClients.create(new ConnectionString(mongoURI));
    }
}