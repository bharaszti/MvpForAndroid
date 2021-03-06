package com.example.bence.mvpforandroid.application;

import com.example.bence.mvpforandroid.application.api.MainView;
import com.example.bence.mvpforandroid.infrastructure.Model;

/**
 * Created by bence on 10.08.15.
 */
public class MainPresenter {
    private Model model;
    private MainView view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(MainView view) {
        this.view = view;
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

    public void about() {
        view.openAboutDialog();
    }
}
