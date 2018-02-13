package com.beetle.section3.databasedemo.jpa;

import com.beetle.section3.databasedemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(JpaDemoApplication.class);
    private final PersonJpaRepository jpaRepository;

    @Autowired
    public JpaDemoApplication(PersonJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Find
        Person person = jpaRepository.find(10002L);
        LOGGER.info("Person with id 10002: " + person);

        // Update
        person.setName("Teszt");
        jpaRepository.update(person);
        LOGGER.info("Person with id 10002 updated: " + jpaRepository.find(10002L));

        // Insert
        jpaRepository.update(new Person("Jákób", "Kecskemét", new Date()));
        LOGGER.info("All after insert: " + jpaRepository.findAll());

        // Delete
        jpaRepository.delete(10001L);
        LOGGER.info("All after 10001 deleted: " + jpaRepository.findAll());
    }

}
