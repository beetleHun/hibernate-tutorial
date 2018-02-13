package com.beetle.hibernate;

import com.beetle.hibernate.dao.CourseDao;
import com.beetle.hibernate.model.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateDemoApplication.class)
public class CourseTest {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseDao courseDao;

    @Test
    public void courseFindTest() {
        Course courseToSave = new Course("Jani");
        Long savedId = courseDao.save(courseToSave).getId();
        assertNotNull(courseDao.findById(savedId));

        courseDao.deleteById(savedId);
        assertNull(courseDao.findById(savedId).orElse(null));

        LOGGER.info("Test is done");
    }

}
