package com.example.bence.mvpforandroid;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickSave(View view) {
        Person person = new Person();
        person.setName(name.getText().toString().trim());
        presenter.createNewPerson(person);
    }

    public void onClickCancel(View view) {
        presenter.cancel();
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
