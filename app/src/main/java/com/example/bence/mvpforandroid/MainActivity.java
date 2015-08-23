package com.example.bence.mvpforandroid;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView numberOfPersons;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createView();
        createPresenter();
    }

    private void createView() {
        numberOfPersons = (TextView) findViewById(R.id.numberOfPersonsTextView);
    }

    private void createPresenter() {
        presenter = new MainPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            presenter.about();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickNewPerson(View view) {
        presenter.newPerson();
    }

    public void onClickPersons(View view) {
        presenter.openPersons();
    }

    public void update(List<Person> persons) {
        numberOfPersons.setText("Number of persons: " + persons.size());
    }

    public void openNewPersonView() {
        Intent intent = new Intent(this, NewPersonActivity.class);
        startActivity(intent);
    }

    public void openPersonsView() {
        Intent intent = new Intent(this, PersonsActivity.class);
        startActivity(intent);
    }

    public void openAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "MVP for Android";
        String message = "This is little example implementation of the Model View Presenter pattern using Android activities as passive views.\n\n" +
                "Author: Bence Haraszti\n\n" +
                "Source code: https://github.com/bharaszti/MvpForAndroid";
        builder.setTitle(title).setMessage(message).setPositiveButton("Ok", null).create().show();
    }
}
