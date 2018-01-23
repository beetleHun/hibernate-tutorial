package com.beetle.section3.databasedemo.jpa;

import com.beetle.section3.databasedemo.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll() {
        return entityManager.createQuery("select p from Person p").getResultList();
    }

    public Person find(Long id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
    }

}
