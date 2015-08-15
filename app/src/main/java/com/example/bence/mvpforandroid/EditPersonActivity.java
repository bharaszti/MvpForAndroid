package com.example.bence.mvpforandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class EditPersonActivity extends ActionBarActivity {

    protected static final String PERSON_ID = "person_id";

    private EditPersonPresenter presenter;

    private TextView name;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);

        createView();
        createPresenter();
    }

    private void createView() {
        name = (TextView) findViewById(R.id.nameTextView);
    }

    private void createPresenter() {
        presenter = new EditPersonPresenter();
        presenter.setModel(ModelFactory.getInstance());
        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (person == null) {
            Intent intent = getIntent();
            Integer id = intent.getIntExtra(EditPersonActivity.PERSON_ID, -1);
            presenter.loadPerson(id);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_person, menu);
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

    public void onClickOk(View view) {
        person.setName(name.getText().toString());
        presenter.savePerson(person);
    }

    public void onClickCancel(View view) {
        presenter.cancel();
    }

    public void onClickDelete(View view) {
        presenter.delete();
    }

    public void update(Person person) {
        this.person = person;
        name.setText(person.getName());
    }


    public void close() {
        finish();
    }

    public void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton("Ok", null);
        builder.create().show();
    }

    public void openDeleteConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete person?");

        builder.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteConfirmed(person.getId());
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }
}
