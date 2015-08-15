package com.example.bence.mvpforandroid;

/**
 * Created by bence on 10.08.15.
 */
public class MainPresenter {
    private Model model;
    private MainActivity view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(MainActivity activity) {
        this.view = activity;
    }

    public void refresh() {
        view.update(model.getPersons());
    }

    public void newPerson() {
        view.openNewPersonView();
    }

    public void openPersons() {
        view.openPersonsView();
    }
}
