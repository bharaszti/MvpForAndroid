package com.example.bence.mvpforandroid.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.bence.mvpforandroid.R;
import com.example.bence.mvpforandroid.application.MainPresenter;
import com.example.bence.mvpforandroid.application.PresenterFactory;
import com.example.bence.mvpforandroid.application.api.MainView;
import com.example.bence.mvpforandroid.domain.Person;

import java.util.List;


public class MainActivity extends ActionBarActivity implements MainView {

    private MainPresenter presenter;

    private TextView numberOfPersons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = PresenterFactory.createMainPresenter(this);
        createUI();
    }

    private void createUI() {
        numberOfPersons = (TextView) findViewById(R.id.numberOfPersonsTextView);
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
        builder.setPositiveButton("Close", null);

        String title = "MVP for Android";
        builder.setTitle(title);

        String message = "This is a simple example for the " +
                "Model View Presenter (passive view) pattern using Android activities.\n\n" +
                "Author: Bence Haraszti\n\n" +
                "Source code: https://github.com/bharaszti/MvpForAndroid";
        SpannableString spannableMessage = new SpannableString(message);
        Linkify.addLinks(spannableMessage, Linkify.ALL);
        builder.setMessage(spannableMessage);

        AlertDialog dialog = builder.show();
        ((TextView) dialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
    }
}
