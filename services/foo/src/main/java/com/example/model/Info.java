package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by libin on 5/16/16.
 */

@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String value;

    protected Info(){}

    public Info(String name, String value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("Backend %s - %s", name, value);
    }
}
