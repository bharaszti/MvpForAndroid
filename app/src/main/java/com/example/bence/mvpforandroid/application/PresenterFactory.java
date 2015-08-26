package com.example.bence.mvpforandroid.application;

import com.example.bence.mvpforandroid.application.api.EditPersonView;
import com.example.bence.mvpforandroid.application.api.MainView;
import com.example.bence.mvpforandroid.application.api.NewPersonView;
import com.example.bence.mvpforandroid.application.api.PersonsView;
import com.example.bence.mvpforandroid.infrastructure.ModelFactory;

/**
 * Created by bence on 25.08.15.
 */
public class PresenterFactory {
    public static MainPresenter createMainPresenter(MainView view) {
        MainPresenter presenter = new MainPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(view);
        return presenter;
    }

    public static EditPersonPresenter createEditPresenter(EditPersonView view) {
        EditPersonPresenter presenter = new EditPersonPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(view);
        return presenter;
    }

    public static NewPersonPresenter createNewPersonPresenter(NewPersonView view) {
        NewPersonPresenter presenter = new NewPersonPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(view);
        return presenter;
    }

    public static PersonsPresenter createPersonsPresenter(PersonsView view) {
        PersonsPresenter presenter = new PersonsPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(view);
        return presenter;
    }
}
