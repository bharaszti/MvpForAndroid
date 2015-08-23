package com.example.bence.mvpforandroid.ui;

import android.app.AlertDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bence.mvpforandroid.application.ModelFactory;
import com.example.bence.mvpforandroid.application.NewPersonPresenter;
import com.example.bence.mvpforandroid.R;
import com.example.bence.mvpforandroid.domain.Person;


public class NewPersonActivity extends ActionBarActivity {

    private NewPersonPresenter presenter;

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);

        createView();
        createPresenter();
    }

    private void createView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);

        name = (TextView) findViewById(R.id.nameTextView);
    }

    private void createPresenter() {
        presenter = new NewPersonPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_person, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                presenter.cancel();
                return true;
            case R.id.action_save:
                Person person = new Person();
                person.setName(name.getText().toString().trim());
                presenter.createNewPerson(person);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void close() {
        finish();
    }

    public void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton("Ok", null);
        builder.create().show();
    }
}
