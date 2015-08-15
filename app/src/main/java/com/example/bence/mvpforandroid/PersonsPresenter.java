package com.example.bence.mvpforandroid;

/**
 * Created by bence on 13.08.15.
 */
public class PersonsPresenter {
    private Model model;
    private PersonsActivity view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(PersonsActivity activity) {
        this.view = activity;
    }

    public void refresh() {
        view.update(model.getPersons());
    }

    public void editPerson(int id) {
        view.openEditPersonView(id);

    }
}
