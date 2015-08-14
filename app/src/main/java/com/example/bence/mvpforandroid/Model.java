package com.example.bence.mvpforandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bence on 10.08.15.
 */
public class Model {
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public void newPerson(Person person) throws ValidationException {
        validateNotEmpty(person);
        validateUnique(person);
        persons.add(person);
    }

    private void validateNotEmpty(Person person) throws ValidationException {
        if (person == null || person.getName().isEmpty()) {
            throw new ValidationException("Enter a name!");
        }
    }

    private void validateUnique(Person person) throws ValidationException {
        for (Person current : persons) {
            if (current.getName().equals(person.getName())) {
                throw new ValidationException("Person with this name already exists!");
            }
        }
    }

}
