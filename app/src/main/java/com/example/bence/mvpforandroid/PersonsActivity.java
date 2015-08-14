package com.example.bence.mvpforandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PersonsActivity extends ActionBarActivity {

    private PersonsPresenter presenter;

    private ListView personsListView;
    private ArrayAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);

        createView();
        createPresenter();
    }

    private void createView() {
        personsListView = (ListView) findViewById(R.id.personsListView);

        personsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<Person>());
        personsListView.setAdapter(personsAdapter);
    }

    private void createPresenter() {
        presenter = new PersonsPresenter();
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
        getMenuInflater().inflate(R.menu.menu_list_persons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void update(List<Person> persons) {
        personsAdapter.clear();
        personsAdapter.addAll(persons);
        personsAdapter.notifyDataSetChanged();
    }
}