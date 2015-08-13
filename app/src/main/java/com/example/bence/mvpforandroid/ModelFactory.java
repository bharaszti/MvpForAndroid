package com.example.bence.mvpforandroid;

/**
 * Created by bence on 12.08.15.
 */
public class ModelFactory {
    private static Model INSTANCE = null;

    public static Model getInstance() {
        if (INSTANCE  == null) {
            INSTANCE = new Model();
        }
        return INSTANCE;
    }
}
