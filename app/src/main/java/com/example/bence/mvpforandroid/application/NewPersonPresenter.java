package com.example.bence.mvpforandroid.application;

import com.example.bence.mvpforandroid.infrastructure.Model;
import com.example.bence.mvpforandroid.application.api.NewPersonView;
import com.example.bence.mvpforandroid.util.ValidationException;
import com.example.bence.mvpforandroid.domain.Person;

/**
 * Created by bence on 10.08.15.
 */
public class NewPersonPresenter {
    private Model model;
    private NewPersonView view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(NewPersonView view) {
        this.view = view;
    }

    public void createNewPerson(Person person) {
        try {
            model.newPerson(person);
            view.close();
        } catch (ValidationException e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    public void cancel() {
        view.close();
    }
}
