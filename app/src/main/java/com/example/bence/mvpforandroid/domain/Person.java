package com.example.bence.mvpforandroid.domain;

/**
 * Created by bence on 10.08.15.
 */
public class Person {
    private String name;
    private Integer id;

    public Person() {
    }

    public Person(Person person) {
        this.id = person.id;
        this.name = person.name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

