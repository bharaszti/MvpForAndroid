package com.example.bence.mvpforandroid.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bence.mvpforandroid.R;
import com.example.bence.mvpforandroid.application.PersonsPresenter;
import com.example.bence.mvpforandroid.application.PresenterFactory;
import com.example.bence.mvpforandroid.application.api.PersonsView;
import com.example.bence.mvpforandroid.domain.Person;

import java.util.ArrayList;
import java.util.List;


public class PersonsActivity extends ActionBarActivity implements PersonsView, AdapterView.OnItemClickListener {

    private PersonsPresenter presenter;

    private ListView personsListView;
    private ArrayAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);

        presenter = PresenterFactory.createPersonsPresenter(this);
        createUI();
    }

    private void createUI() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        personsListView = (ListView) findViewById(R.id.personsListView);
        personsListView.setOnItemClickListener(this);

        personsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<Person>());
        personsListView.setAdapter(personsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_persons, menu);
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
                presenter.back();
                return true;
            case R.id.action_new_person:
                presenter.newPerson();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person person = (Person) personsAdapter.getItem(position);
        presenter.editPerson(person.getId());
    }

    public void onClickNewPerson(View view) {
        presenter.newPerson();
    }

    public void onClickBack(View view) {
        presenter.back();
    }

    public void update(List<Person> persons) {
        personsAdapter.clear();
        personsAdapter.addAll(persons);
        personsAdapter.notifyDataSetChanged();
    }

    public void openEditPersonView(int id) {
        Intent intent = new Intent(this, EditPersonActivity.class);
        intent.putExtra(EditPersonActivity.PERSON_ID, id);
        startActivity(intent);
    }

    public void openNewPersonView() {
        Intent intent = new Intent(this, NewPersonActivity.class);
        startActivity(intent);
    }

    public void close() {
        finish();
    }
}
