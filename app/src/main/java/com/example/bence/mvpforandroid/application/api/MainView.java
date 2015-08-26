package com.example.bence.mvpforandroid.application.api;

import com.example.bence.mvpforandroid.domain.Person;

import java.util.List;

/**
 * Created by bence on 25.08.15.
 */
public interface MainView {

    void update(List<Person> persons);

    void openNewPersonView();

    void openPersonsView();

    void openAboutDialog();
}
