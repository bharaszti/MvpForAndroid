package com.example.bence.mvpforandroid.infrastructure;

import com.example.bence.mvpforandroid.domain.Person;
import com.example.bence.mvpforandroid.util.ValidationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bence on 10.08.15.
 */
public class Model {
    private List<Person> persons = new ArrayList<>();
    private int nextId;

    public List<Person> getPersons() {
        return persons;
    }

    public void newPerson(Person person) throws ValidationException {
        validateNotEmpty(person);
        validateUnique(person);

        Person modelPerson = new Person(person);
        modelPerson.setId(getNextId());
        persons.add(modelPerson);
    }

    public void updatePerson(Person person) throws ValidationException {
        validateNotEmpty(person);
        validateUnique(person);

        Person modelPerson = getPersonById(person.getId());
        modelPerson.setName(person.getName());
    }

    public Person getPersonById(Integer id) {
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        // TODO: this should never happen
        return null;
    }

    private void validateNotEmpty(Person person) throws ValidationException {
        if (person == null || person.getName().isEmpty()) {
            throw new ValidationException("Enter a name!");
        }
    }

    private void validateUnique(Person person) throws ValidationException {
        for (Person current : persons) {
            boolean sameName = current.getName().equals(person.getName());
            boolean sameId = current.getId().equals(person.getId());
            if (sameName && !sameId) {
                throw new ValidationException("Person with this name already exists!");
            }
        }
    }

    private int getNextId() {
        return nextId++;
    }

    public void deletePerson(Integer id) {
        Person person = getPersonById(id);
        persons.remove(person);
    }
}
