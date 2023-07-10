package com.example.clusterdatawarehouse.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IDGenerator {
    private static final String MODEL_ID = "id";
    @Autowired
    private MongoTemplate mongoTemplate;
        public <T> String generateUniqueId(Class<T> clazz) {
            String uuid = UUID.randomUUID().toString();
           Query query = Query.query(Criteria.where(MODEL_ID).is(uuid));
           if (mongoTemplate.exists(query,clazz)){
               generateUniqueId(clazz);
            }
         return uuid;
        }
}
