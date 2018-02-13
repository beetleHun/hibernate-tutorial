package com.beetle.section3.databasedemo;

import com.beetle.section3.databasedemo.jdbc.PersonJdbcDao;
import com.beetle.section3.databasedemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

    private final PersonJdbcDao personJdbcDao;

    @Autowired
    public JdbcDemoApplication(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(personJdbcDao.findAll());
        System.out.println(personJdbcDao.findById(10001L));
        System.out.println(personJdbcDao.findSimilarName("bi"));
        System.out.println(personJdbcDao.delete(10001L));
        System.out.println(personJdbcDao.findAll());
        System.out.println(personJdbcDao.insert(new Person(10006L, "Feri", "Pest", new Date())));
        System.out.println(personJdbcDao.update(new Person(10005L, "Tóni", "Pest", new Date())));
    }

}
