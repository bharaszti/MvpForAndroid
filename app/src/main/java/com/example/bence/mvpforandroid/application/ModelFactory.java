package com.example.bence.mvpforandroid.application;

import com.example.bence.mvpforandroid.infrastructure.Model;

/**
 * Created by bence on 12.08.15.
 */
public class ModelFactory {
    private static Model MODEL_INSTANCE = null;

    public static Model getInstance() {
        if (MODEL_INSTANCE == null) {
            MODEL_INSTANCE = new Model();
        }
        return MODEL_INSTANCE;
    }
}
