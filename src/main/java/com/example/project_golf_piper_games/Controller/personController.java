package com.example.project_golf_piper_games.Controller;

import com.example.project_golf_piper_games.Classes.Person;
import com.example.project_golf_piper_games.HelloApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class personController {

    EntityManagerFactory entityManagerFactory = HelloApplication.ENTITY_MANAGER_FACTORY;

    public personController(){
    }

    public boolean addPerson(Person thePerson){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(thePerson);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            isSuccess = false;
        }finally {
            entityManager.close();
        }
        return isSuccess;
    }

    public List<Person> getAllPersons() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Person> personList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Person> allPersonsQuery = entityManager.createQuery("from Person", Person.class);
            personList = allPersonsQuery.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return personList;

    }

}

