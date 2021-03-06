package com.essolares.rest.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.essolares.rest.model.Person;

public interface PersonDao {
    
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    };

    List<Person> selectAllPerson();

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);

}
