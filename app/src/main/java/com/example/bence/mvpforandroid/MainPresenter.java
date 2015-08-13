package com.example.bence.mvpforandroid;

/**
 * Created by bence on 10.08.15.
 */
public class MainPresenter {
    private Model model;
    private MainActivity mainActivity;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void updateView() {
        mainActivity.update(model.getPersons());
    }

    public void getNewPerson() {
        mainActivity.openNewPersonView();
    }
}
