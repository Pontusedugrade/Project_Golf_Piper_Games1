package com.example.project_golf_piper_games.Controller;

import com.example.project_golf_piper_games.Classes.Address;
import com.example.project_golf_piper_games.HelloApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class addressController {
    EntityManagerFactory entityManagerFactory = HelloApplication.ENTITY_MANAGER_FACTORY;

    public addressController(){
    }

    public boolean addAddress(Address theAddress){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccess = true;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(theAddress);
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

    public List<Address> getAddress(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Address> addressList = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Address> allAddressQuery = entityManager.createQuery("from Address ", Address.class);
            addressList = allAddressQuery.getResultList();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return addressList;

    }
}