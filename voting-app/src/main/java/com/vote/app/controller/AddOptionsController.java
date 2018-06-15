package com.vote.app.controller;

import com.vote.app.model.Option;
import com.vote.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddOptionsController {

    @Autowired
    AppRepository appRepository;

    /*
        sample insert json:
            {"option": "bear"}
     */

    @RequestMapping(method = RequestMethod.POST)
    public Option addNewOption(@RequestBody Option option){

        Option exists = appRepository.findByOption(option.getOption());

        if(exists == null){
            Option result = appRepository.save(option);
            option.setVotes(0);
            return result;
        } else{
            return null;
        }
    }


}
