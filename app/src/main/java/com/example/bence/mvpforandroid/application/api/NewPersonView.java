package com.example.bence.mvpforandroid.application.api;

import com.example.bence.mvpforandroid.domain.Person;

/**
 * Created by bence on 26.08.15.
 */
public interface NewPersonView {

    void close();

    void showErrorMessage(String message);
}
