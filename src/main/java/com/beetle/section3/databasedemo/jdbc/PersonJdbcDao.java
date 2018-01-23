package com.beetle.section3.databasedemo.jdbc;

import com.beetle.section3.databasedemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    @Autowired
    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(Long id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findSimilarName(String pattern) {
        return jdbcTemplate.query("select * from person where name like '%%" + pattern + "'", new BeanPropertyRowMapper<Person>(Person.class));

    }

    public int delete(Long id) {
        return jdbcTemplate.update("delete from person where id = ?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?,?,?,?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id=?",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
    }

}
