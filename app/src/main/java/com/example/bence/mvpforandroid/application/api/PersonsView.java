package com.example.bence.mvpforandroid.application.api;

import com.example.bence.mvpforandroid.domain.Person;

import java.util.List;

/**
 * Created by bence on 26.08.15.
 */
public interface PersonsView {
    void update(List<Person> persons);

    void openEditPersonView(int id);

    void openNewPersonView();

    void close();
}
