package com.essolares.rest.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.essolares.rest.model.Person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;
    
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> selectAllPerson() {
        final String sql = "SELECT id,name FROM person";
        List<Person> people = jdbcTemplate.query(sql, (resultSet,i) -> {
            return new Person(UUID.fromString(
                resultSet.getString("id")),
            resultSet.getString("name"));
        });
        return people;
        //return List.of(new Person(UUID.randomUUID(),"From Postgres DB"));
    }

    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id,name FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(
            sql, 
            new Object[]{id}, 
            (resultSet,i) -> {
                UUID personId = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                return new Person(personId,name);
        });
    }
    
} 