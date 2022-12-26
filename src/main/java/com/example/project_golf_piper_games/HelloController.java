package com.example.project_golf_piper_games;

import com.example.project_golf_piper_games.Classes.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
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

  @FXML
  private TableView<Employee> employeeTable;
  @FXML
  private TableColumn<Employee, Integer> idColumn;
  @FXML
  private TableColumn<Employee, String> firstNameColumn;
  @FXML
  private TableColumn<Employee, String> lastNameColumn;
  @FXML
  private TableColumn<Employee, String> nickNameColumn;
  @FXML
  private TableColumn<Employee, String> eMailColumn;
  @FXML
  private TableColumn<Employee, String> countryColumn;
  @FXML
  private TableColumn<Employee, String> cityColumn;
  @FXML
  private TableColumn<Employee, String> addressColumn;
  @FXML
  private TableColumn<Employee, Integer> zipColumn;
  @FXML
  private TextField firstNameTextField;
  @FXML
  private TextField lastNameTextField;
  @FXML
  private TextField nickNameTextField;
  @FXML
  private TextField eMailTextField;
  @FXML
  private TextField countryTextField;
  @FXML
  private TextField cityTextField;
  @FXML
  private TextField addressTextField;
  @FXML
  private TextField zipTextField;
  @FXML
  private Button saveNewEmployeeButton;

  @FXML
  private TableView<Player> playerTable;
  @FXML
  private TableColumn<Player, Integer> idColumnP;
  @FXML
  private TableColumn<Player, String> firstNameColumnP;
  @FXML
  private TableColumn<Player, String> lastNameColumnP;
  @FXML
  private TableColumn<Player, String> nickNameColumnP;
  @FXML
  private TableColumn<Player, String> eMailColumnP;
  @FXML
  private TableColumn<Player, String> countryColumnP;
  @FXML
  private TableColumn<Player, String> cityColumnP;
  @FXML
  private TableColumn<Player, String> addressColumnP;
  @FXML
  private TableColumn<Player, Integer> zipColumnP;
  @FXML
  private TableColumn<Player, String> gameColumn;
  @FXML
  private TableColumn<Player, String> teamColumn;

  @FXML
  private TextField firstNameTextFieldP;
  @FXML
  private TextField lastNameTextFieldP;
  @FXML
  private TextField nickNameTextFieldP;
  @FXML
  private TextField eMailTextFieldP;
  @FXML
  private TextField countryTextFieldP;
  @FXML
  private TextField cityTextFieldP;
  @FXML
  private TextField addressTextFieldP;
  @FXML
  private TextField zipTextFieldP;
  @FXML
  private TextField gameTextField;
  @FXML
  private TextField teamTextField;
  @FXML
  private Button saveNewPlayerButton;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeId"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
    nickNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("nickName"));
    eMailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("mailAddress"));
    countryColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("country"));
    cityColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("city"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
    zipColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("zip"));

    idColumnP.setCellValueFactory(new PropertyValueFactory<Player, Integer>("employeeId"));
    firstNameColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));
    lastNameColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));
    nickNameColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("nickName"));
    eMailColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("mailAddress"));
    countryColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
    cityColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("city"));
    addressColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("address"));
    zipColumnP.setCellValueFactory(new PropertyValueFactory<Player, Integer>("zip"));
    gameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("gameName"));
    teamColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("teamName"));

    employeeTable.getItems().setAll(getAllEmployees());
    //playerTable.getItems().setAll(getAllPlayers());

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

    playerTable.getSelectionModel().selectedItemProperty().addListener((observableValue, player, t1) -> {
      firstNameTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getFirstName());
      lastNameTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getLastName());
      nickNameTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getNickName());
      eMailTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getMailAddress());
      countryTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getCityId().getCountryId().getCountryName());
      cityTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getCityId().getCity());
      addressTextFieldP.setText(playerTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getAddress());
      zipTextFieldP.setText(String.valueOf(playerTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getZip()));
      gameTextField.setText(playerTable.getSelectionModel().getSelectedItem().getGameId().getGameName());
      teamTextField.setText(playerTable.getSelectionModel().getSelectedItem().getTeamId().getTeamName());
    });
  }

  public void addEmployee() {
    Country newCountry = new Country(countryTextField.getText());
    PostalAddress newPostalAddress = new PostalAddress(newCountry, cityTextField.getText());
    Address newAddress = new Address(addressTextField.getText(), Integer.parseInt(zipTextField.getText()), newPostalAddress);
    Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText(), nickNameTextField.getText(), eMailTextField.getText(), newAddress);
    Employee newEmployee = new Employee(newPerson);
    saveEmployee(newCountry, newPostalAddress, newAddress, newPerson, newEmployee);
  }
  // We're gonna need 2 methods for adding a player and 2 buttons. One for adding a player that has a team and one that doesn't.
  public void addPlayer() {
    Country newCountry = new Country(countryTextFieldP.getText());
    PostalAddress newPostalAddress = new PostalAddress(newCountry, cityTextFieldP.getText());
    Address newAddress = new Address(addressTextFieldP.getText(), Integer.parseInt(zipTextFieldP.getText()), newPostalAddress);
    Person newPerson = new Person(firstNameTextFieldP.getText(), lastNameTextFieldP.getText(), nickNameTextFieldP.getText(), eMailTextFieldP.getText(), newAddress);
    Game newGame = new Game(gameTextField.getText());
    Team newTeam = new Team(teamTextField.getText(), newGame);

  }


  public List<Employee> getAllEmployees() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    List<Employee> employees = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      TypedQuery<Employee> allEmployeesQuery = entityManager.createQuery("from Employee ", Employee.class);
      employees = allEmployeesQuery.getResultList();
      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      entityManager.close();
    }
    return employees;
  }

  public boolean saveEmployee(Country country, PostalAddress postalAddress, Address address, Person person, Employee employee) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    boolean isSuccessful = true;

    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      entityManager.persist(country);
      entityManager.persist(postalAddress);
      entityManager.persist(address);
      entityManager.persist(person);
      entityManager.persist(employee);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
      isSuccessful = false;
    } finally {
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