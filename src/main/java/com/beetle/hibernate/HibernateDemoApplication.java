package com.beetle.hibernate;

import com.beetle.hibernate.dao.CourseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateDemoApplication.class);
    private final CourseDao courseDao;

    @Autowired
    public HibernateDemoApplication(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(courseDao.findById(1L).toString());
    }

}
