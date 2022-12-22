package com.example.project_golf_piper_games.Controller;

import com.example.project_golf_piper_games.Classes.Employee;
import com.example.project_golf_piper_games.Classes.Person;
import com.example.project_golf_piper_games.HelloApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class employeeController {

    EntityManagerFactory entityManagerFactory = HelloApplication.ENTITY_MANAGER_FACTORY;

    public employeeController(){

    }

    public List<Person> getAllPersons(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Person> personList = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Person> allPersonsQuery = entityManager.createQuery("from Person ", Person.class);
            personList = allPersonsQuery.getResultList();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return personList;
    }

    public List<Employee> getAllEmployees(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Employee> employeeList = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Employee> allEmployeesQuery = entityManager.createQuery("from Employee ", Employee.class);
            employeeList = allEmployeesQuery.getResultList();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return employeeList;
    }

    public boolean addEmployee(Employee theEmployee){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(theEmployee);
            transaction.commit();
        }catch (Exception e) {
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

}

