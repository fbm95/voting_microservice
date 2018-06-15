package com.vote.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="options")
public class Option {

    @Id
    private String id;

    private String option;
    private int votes;

    public Option(){
        this.option = "";
        this.votes = 0;
    }

    public Option(String id, int votes) {
        this.id = id;
        this.votes = votes;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getVotes(){
        return this.votes;
    }

    public void setVotes(int votes){
        this.votes = votes;
    }

}
