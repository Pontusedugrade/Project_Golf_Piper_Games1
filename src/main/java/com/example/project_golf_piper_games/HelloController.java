package com.example.project_golf_piper_games;

import com.example.project_golf_piper_games.Classes.*;
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


    /*@FXML private TableView<Person> personTable;
    @FXML private TableColumn<Person, Integer> idColumn;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, String> nickNameColumn;
    @FXML private TableColumn<Person, String> eMailColumn;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField nickNameTextField;
    @FXML private TextField eMailTextField;
    @FXML private Button saveNewPersonButton;*/

    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, Integer> idColumn;
    @FXML private TableColumn<Employee, Person> firstNameColumn;
    @FXML private TableColumn<Employee, Person> lastNameColumn;
    @FXML private TableColumn<Employee, Person> nickNameColumn;
    @FXML private TableColumn<Employee, Person> eMailColumn;
    @FXML private TableColumn<Employee, Country> countryColumn;
    @FXML private TableColumn<Employee, PostalAddress> cityColumn;
    @FXML private TableColumn<Employee, Address> addressColumn;
    @FXML private TableColumn<Employee, Address> zipColumn;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField nickNameTextField;
    @FXML private TextField eMailTextField;
    @FXML private TextField countryTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField zipTextField;
    @FXML private Button saveNewEmployeeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, Person>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, Person>("lastName"));
        nickNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, Person>("nickName"));
        eMailColumn.setCellValueFactory(new PropertyValueFactory<Employee, Person>("mailAddress"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Country>("country"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Employee, PostalAddress>("city"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, Address>("address"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<Employee, Address>("zip"));
        employeeTable.getItems().setAll(getAllEmployees());

        employeeTable.getSelectionModel().selectedItemProperty().addListener((observableValue, employee, t1) -> {
            firstNameTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getFirstName());
            lastNameTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getLastName());
            nickNameTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getNickName());
            eMailTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getMailAddress());
            countryTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getCityId().getCountryId().getCountryName());
            cityTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getCityId().getCity());
            addressTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getAddress());
            zipTextField.setText(String.valueOf(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getZip()));
        });
    }

    public void addAndSaveEmployee() {
        Country newCountry = new Country(countryTextField.getText());
        PostalAddress newPostalAddress = new PostalAddress(newCountry, cityTextField.getText());
        Address newAddress = new Address(addressTextField.getText(), Integer.parseInt(zipTextField.getText()), newPostalAddress);
        Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText(), nickNameTextField.getText(), eMailTextField.getText(), newAddress);
        Employee newEmployee = new Employee(newPerson);
        employeeAddingProcess(newCountry, newPostalAddress, newAddress, newPerson, newEmployee);
    }

    public List<Employee> getAllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List <Employee> employees = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery <Employee> allEmployeesQuery = entityManager.createQuery("from Employee ", Employee.class);
            employees = allEmployeesQuery.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return employees;
    }

    public boolean employeeAddingProcess(Country country, PostalAddress postalAddress, Address address, Person person, Employee employee){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        boolean isSuccessful = true;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(country);
            entityManager.persist(postalAddress);
            entityManager.persist(address);
            entityManager.persist(person);
            entityManager.persist(employee);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            isSuccessful = false;
        }finally {
            entityManager.close();
        }
        return isSuccessful;
    }

    /*@Override
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
    }*/

    /*public void saveNewPersonButtonWasClicked() {
            Person personToAdd = new Person(firstNameTextField.getText(), lastNameTextField.getText(),nickNameTextField.getText(), eMailTextField.getText());
            addPerson(personToAdd);
        }*/

    /*public boolean addPerson(Person thePerson){
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
    }*/

    /*public List<Person> getAllPersons() {
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

    }*/


}