package com.example.bence.mvpforandroid.application;

import com.example.bence.mvpforandroid.application.api.PersonsView;
import com.example.bence.mvpforandroid.infrastructure.Model;

/**
 * Created by bence on 13.08.15.
 */
public class PersonsPresenter {
    private Model model;
    private PersonsView view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(PersonsView view) {
        this.view = view;
    }

    public void refresh() {
        view.update(model.getPersons());
    }

    public void editPerson(int id) {
        view.openEditPersonView(id);

    }

    public void newPerson() {
        view.openNewPersonView();
    }

    public void back() {
        view.close();
    }
}
