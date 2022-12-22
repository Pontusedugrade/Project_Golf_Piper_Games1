package com.example.project_golf_piper_games;

import com.example.project_golf_piper_games.Classes.Address;
import com.example.project_golf_piper_games.Classes.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    EntityManagerFactory entityManagerFactory = HelloApplication.ENTITY_MANAGER_FACTORY;

    /**
    * FXML properties
    **/


    @FXML private TableView<Person> personTable;
    @FXML private TableColumn<Person, Integer> idColumn;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, String> nickNameColumn;
    @FXML private TableColumn<Person, String> eMailColumn;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField nickNameTextField;
    @FXML private TextField eMailTextField;
    @FXML private Button saveNewPersonButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("personID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        nickNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("nickName"));
        eMailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("mailAddress"));
        personTable.getItems().setAll(getAllPersons());

        personTable.getSelectionModel().selectedItemProperty().addListener((observableValue, person, t1) -> {
            firstNameTextField.setText(personTable.getSelectionModel().getSelectedItem().getFirstName());
            lastNameTextField.setText(personTable.getSelectionModel().getSelectedItem().getLastName());
            nickNameTextField.setText(personTable.getSelectionModel().getSelectedItem().getNickName());
            eMailTextField.setText(personTable.getSelectionModel().getSelectedItem().getMailAddress());
        });
    }

        public void saveNewPersonButtonWasClicked() {
            Person personToAdd = new Person(firstNameTextField.getText(), lastNameTextField.getText(),nickNameTextField.getText(), eMailTextField.getText());
            addPerson(personToAdd);
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