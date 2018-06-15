package com.vote.app.controller;

import com.vote.app.model.Option;
import com.vote.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VotingController {

    @Autowired
    AppRepository appRepository;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public VotingController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Option> getOptions(){

        List<Option> votingOptions;

        SampleOperation sampleStage = Aggregation.sample(2);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        AggregationResults<Option> output = mongoTemplate.aggregate(aggregation, "options", Option.class);

        votingOptions = output.getMappedResults();

        return votingOptions;
    }

    /*
        sample vote json:
            {"option": "duck","votes": 0}
     */

    @RequestMapping(method = RequestMethod.POST)
    public Option vote(@RequestBody Option option){

        Option voted = appRepository.findByOption(option.getOption());

        voted.setVotes(voted.getVotes()+1);
        Option result = appRepository.save(voted);
        return result;
    }

}

