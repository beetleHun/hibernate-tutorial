package com.beetle.hibernate.dao;

import com.beetle.hibernate.model.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Course, Long> {
}
