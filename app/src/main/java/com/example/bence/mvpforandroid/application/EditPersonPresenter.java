package com.example.bence.mvpforandroid.application;

import com.example.bence.mvpforandroid.ui.EditPersonActivity;
import com.example.bence.mvpforandroid.infrastructure.Model;
import com.example.bence.mvpforandroid.util.ValidationException;
import com.example.bence.mvpforandroid.domain.Person;

/**
 * Created by bence on 15.08.15.
 */
public class EditPersonPresenter {
    private Model model;
    private EditPersonActivity view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(EditPersonActivity activity) {
        this.view = activity;
    }

    public void loadPerson(Integer id) {
        Person person = new Person(model.getPersonById(id));
        view.update(person);
    }

    public void savePerson(Person person) {
        try {
            model.updatePerson(person);
            view.close();
        } catch (ValidationException e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    public void cancel() {
        view.close();
    }

    public void delete() {
        view.openDeleteConfirmation();
    }

    public void deleteConfirmed(Integer id) {
        model.deletePerson(id);
        view.close();
    }
}
