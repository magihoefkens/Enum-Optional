package org.example;

import java.util.*;

public class PersonRepository {
    private Map<String,Person> persons=new HashMap<>();

    public Map<String,Person> getPersons() {
        return persons;
    }
    public Optional<Person> getPersonById(String id){
       // Person pers=this.persons.get(id);
        return Optional.ofNullable(this.persons.get(id));

    }

    public void setPersons(Map<String, Person> persons) {
        this.persons = persons;
    }

}
