package com.vote.app.repository;

import com.vote.app.model.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppRepository  extends MongoRepository<Option, String> {
    public Option findByOption(String option);

}
