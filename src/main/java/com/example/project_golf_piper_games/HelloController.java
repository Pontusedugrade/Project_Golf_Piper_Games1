package com.example.project_golf_piper_games;

import com.example.project_golf_piper_games.Classes.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

  EntityManagerFactory entityManagerFactory = HelloApplication.ENTITY_MANAGER_FACTORY;

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

    // FXML properties for the employee table.

    // Table view.
    @FXML
    private TableView<Employee> employeeTable;

    // Columns
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

    // Text fields.
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
    private TextField idColumnTextField;

    // Button for adding and saving an employee.
    @FXML
    private Button saveNewEmployeeButton;

    @FXML
    private Button deleteEmployeeButton;


    // FXML properties for the player table.

    // Table view.
    @FXML
    private TableView<Player> playerTable;

    // Columns.
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

    // Text fields.
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

    // Here we have 2 buttons. One for adding a solo player (doesn't have a team) and another for the opposite.
    @FXML
    private Button saveNewSoloPlayerButton;

    @FXML
    private Button saveNewTeamPlayerButton;



    // FXML properties to a matchup.

    //Table view
    @FXML
    private TableView<Matchup1Vs1> matchup1Vs1Table;

    //Columns
    @FXML
    private TableColumn<Matchup1Vs1, Integer> idColumnM1;
    @FXML
    private TableColumn<Matchup1Vs1, String> player1ColumnM1;
    @FXML
    private TableColumn<Matchup1Vs1, String> player2ColumnM1;
    @FXML
    private TableColumn<Matchup1Vs1, LocalDate> matchupDateColumnM1; // Not sure if this datatype should be LocalDateTime or String.
    @FXML
    private TableColumn<Matchup1Vs1, String> winnerColumnM1;
    @FXML
    private TableColumn<Matchup1Vs1, Integer> scorePlayer1ColumnM1;
    @FXML
    private TableColumn<Matchup1Vs1, Integer> scorePlayer2ColumnM1;
    @FXML
    private TableColumn<Matchup1Vs1, String> gameColumnM1;

    // Text fields
    @FXML
    private TextField player1TextField;
    @FXML
    private TextField player2TextField;
    @FXML
    private TextField winnerM1TextField;
    @FXML
    private TextField gameTextFieldM1;
    @FXML
    private TextField player1ScoreTextField;
    @FXML
    private TextField player2ScoreTextField;
    @FXML
    private TextField matchup1vs1DateTextField;

    // Buttons (Here we also want to add a button to edit the results of a game that has been played.

    @FXML
    private Button saveNewMatchup1Vs1Button;

    //OBS! NEED TO CREATE A addMatchup1Vs1 METHOD To be called when the save button is clicked.


    //FXML Mapping to Game

    //Table View Game

    @FXML
    private TableView <Game> gameTable;

    //Columns
    @FXML
    private TableColumn<Game, Integer> gameIdColumn;
    @FXML
    private TableColumn<Game, String> gameNameColumn;

    //Text Fields
    @FXML
    private TextField gameNameTextField;

    //Button
    @FXML
    private Button saveNewGame;




    // Tables mapping
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Employee columns.
        //Added getters "getEmployeeFirstName" etc in employee class so that info could be shown in columns
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeFirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeLastName"));
        nickNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeNickName"));
        eMailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeMailAddress"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeCountry"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeCity"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeAddress"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeZip"));

        // Player columns
        //Some issues regarding team/game IDs, a player need to have both in order to get zero errors. The program is casting nullpointerexception at the moment
        //due to player lacking either gameID or teamID. Tried adding id-value = null and 0 but did not work.
        idColumnP.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerId"));
        firstNameColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerFirstName"));
        lastNameColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerLastName"));
        nickNameColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerNickName"));
        eMailColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerMailAddress"));
        countryColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerCountry"));
        cityColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerCity"));
        addressColumnP.setCellValueFactory(new PropertyValueFactory<Player, String>("playerAddress"));
        zipColumnP.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerZip"));
        gameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerGameName"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("playerTeamName"));

        //Matchup1Vs1 columns.
        idColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, Integer>("matchup1vs1Id"));
        player1ColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, String>("player1Nick"));
        player2ColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, String>("player2Nick"));
        matchupDateColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, LocalDate>("localDate"));
        winnerColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, String>("winnerNick"));
        scorePlayer1ColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, Integer>("player1Score"));
        scorePlayer2ColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, Integer>("player2Score"));
        gameColumnM1.setCellValueFactory(new PropertyValueFactory<Matchup1Vs1, String>("gameName"));

        //Game columns
        gameIdColumn.setCellValueFactory(new PropertyValueFactory<Game, Integer>("gameId"));
        gameNameColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("gameName"));


        // View methods for employee and player and matchup1Vs1.
        employeeTable.getItems().setAll(getAllEmployees());
        playerTable.getItems().setAll(getAllPlayers());
        matchup1Vs1Table.getItems().setAll(getAllMatchup1Vs1s());
        gameTable.getItems().setAll(getAllGames());

        // Employee text fields.
        employeeTable.getSelectionModel().selectedItemProperty().addListener((observableValue, employee, t1) -> {
            firstNameTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getFirstName());
            lastNameTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getLastName());
            nickNameTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getNickName());
            eMailTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getMailAddress());
            countryTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getCityId().getCountryId().getCountryName());
            cityTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getCityId().getCity());
            addressTextField.setText(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getAddress());
            zipTextField.setText(String.valueOf(employeeTable.getSelectionModel().getSelectedItem().getPersonId().getAddressId().getZip()));
            idColumnTextField.setText(String.valueOf(employeeTable.getSelectionModel().getSelectedItem().getEmployeeId()));
        });

        // Player text fields.
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

        //Matchup1Vs1 text fields. (I do not know when these lines of code are active or what it does)
        matchup1Vs1Table.getSelectionModel().selectedItemProperty().addListener((observableValue, matchup1Vs1, t1) -> {
            player1TextField.setText(matchup1Vs1Table.getSelectionModel().getSelectedItem().getPlayer1Id().getPlayerNickName());
            player2TextField.setText(matchup1Vs1Table.getSelectionModel().getSelectedItem().getPlayer2Id().getPlayerNickName());
            gameTextFieldM1.setText(matchup1Vs1Table.getSelectionModel().getSelectedItem().getGameId().getGameName());
            player1ScoreTextField.setText(String.valueOf(matchup1Vs1Table.getSelectionModel().getSelectedItem().getPlayer1Score()));
            player2ScoreTextField.setText(String.valueOf(matchup1Vs1Table.getSelectionModel().getSelectedItem().getPlayer2Score()));
            // Here I created and used a formatter method to turn LocalDateTime to String.
            matchup1vs1DateTextField.setText(localDateToString(matchup1Vs1Table.getSelectionModel().getSelectedItem().getLocalDate()));
            winnerM1TextField.setText(matchup1Vs1Table.getSelectionModel().getSelectedItem().getWinnerId().getPlayerNickName());
        });

        //Game text fields.
        gameTable.getSelectionModel().selectedItemProperty().addListener((observableValue, game, t1) -> {
            gameNameTextField.setText(gameTable.getSelectionModel().getSelectedItem().getGameName());
        });
    }


    //Date to string formatter method.
    public String localDateToString(LocalDate theLocalDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateAsString = theLocalDate.format(formatter);
        return dateAsString;
    }

    //String to date formatter method.
    public LocalDate stringToLocalDate(String theLocalDateString) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(theLocalDateString, customFormatter);
        return localDate;
    }

    //Removing employee by employeeID-input
    public void removeEmployee(){
        int columnId = Integer.parseInt(idColumnTextField.getText());
        deleteEmployee(columnId);
        employeeTable.getItems().setAll(getAllEmployees());

    }
    return employees;
  }

  //Removing employee by employeeID-input
  public void removeEmployee() {
    int columnId = Integer.parseInt(idColumnTextField.getText());
    deleteEmployee(columnId);
    employeeTable.getItems().setAll(getAllEmployees());

  }

  public void deleteEmployee(int columnId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      Employee theEmployeeToRemove = entityManager.find(Employee.class, columnId);
      entityManager.remove(theEmployeeToRemove);
      // Call flush-method of the EntityManager to write changes to the database.
      entityManager.flush();
      // Commit the changes
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      entityManager.close();
    }

    /*Constructor for adding an employee. Each object instantiated is inserted into the table that contains the ID property of that object. For example,
    we instantiate country, and we include it in the Postal Address constructor to get the country ID. We instantiate postal address, and we include it in the address
     constructor to get the postal address ID. And so on*/
    public void addEmployee() {
        Country newCountry = new Country(countryTextField.getText());
        PostalAddress newPostalAddress = new PostalAddress(newCountry, cityTextField.getText());
        Address newAddress = new Address(addressTextField.getText(), Integer.parseInt(zipTextField.getText()), newPostalAddress);
        Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText(), nickNameTextField.getText(), eMailTextField.getText(), newAddress);

        Employee newEmployee = new Employee(newPerson);

        saveEmployee(newCountry, newPostalAddress, newAddress, newPerson, newEmployee);

        employeeTable.getItems().setAll(getAllEmployees());

    }
  }

  public void editEmployee() {
    int employeeId = Integer.parseInt(idColumnTextField.getText());
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      Employee employeeBeingEdited = entityManager.find(Employee.class, employeeId);
      employeeBeingEdited.getPersonId().setFirstName(firstNameTextField.getText());
      employeeBeingEdited.getPersonId().setLastName(lastNameTextField.getText());
      employeeBeingEdited.getPersonId().setMailAddress(eMailTextField.getText());
      employeeBeingEdited.getPersonId().setNickName(nickNameTextField.getText());
      employeeBeingEdited.getPersonId().getAddressId().getCityId().getCountryId().setCountryName(countryTextField.getText());
      employeeBeingEdited.getPersonId().getAddressId().getCityId().setCity(cityTextField.getText());
      employeeBeingEdited.getPersonId().getAddressId().setZip(Integer.parseInt(zipTextField.getText()));
      employeeBeingEdited.getPersonId().getAddressId().setAddress(addressTextField.getText());
      entityManager.merge(employeeBeingEdited);
      transaction.commit();
    } catch (Exception exception) {
      if (transaction != null) {
        transaction.rollback();
      }
      exception.printStackTrace();
    } finally {
      entityManager.close();
      employeeTable.getItems().setAll(getAllEmployees());
    }
  }

  // The constructor of a team player needs a team. So it has its own method and button.
  // Attention!!!!!!!!!!!!
   /*This method is currently not working. The code is correct, but it needs the teams table to be created. If you go to the Player class and check the first constructor,
   you will see that every player created is automatically added to the list of team members based on the team ID. This list exist in Team table which is not coded yet*/

public void addTeamPlayer() {
        Country newCountry = new Country(countryTextFieldP.getText());
        PostalAddress newPostalAddress = new PostalAddress(newCountry, cityTextFieldP.getText());
        Address newAddress = new Address(addressTextFieldP.getText(), Integer.parseInt(zipTextFieldP.getText()), newPostalAddress);
        Person newPerson = new Person(firstNameTextFieldP.getText(), lastNameTextFieldP.getText(), nickNameTextFieldP.getText(), eMailTextFieldP.getText(), newAddress);
        Game newGame = new Game(gameTextField.getText());
        Team newTeam = new Team(teamTextField.getText(), newGame);
        Player newPlayer = new Player(newPerson, newGame, newTeam);
        saveTeamPlayer(newCountry, newPostalAddress, newAddress, newPerson, newGame, newTeam, newPlayer);
    }

    // This method is the same as the above but without a team property. It also has its own button. This one is working
    public void addSoloPlayer() {
        Country newCountry = new Country(countryTextFieldP.getText());
        PostalAddress newPostalAddress = new PostalAddress(newCountry, cityTextFieldP.getText());
        Address newAddress = new Address(addressTextFieldP.getText(), Integer.parseInt(zipTextFieldP.getText()), newPostalAddress);
        Person newPerson = new Person(firstNameTextFieldP.getText(), lastNameTextFieldP.getText(), nickNameTextFieldP.getText(), eMailTextFieldP.getText(), newAddress);
        Game newGame = new Game(gameTextField.getText());
        Player newPlayer = new Player(newPerson, newGame);
        saveSoloPlayer(newCountry, newPostalAddress, newAddress, newPerson, newGame, newPlayer);
    }

    public void addMatchup1Vs1() {

        //Create two players and get their object that is already created from the player id in the database by using getPlayer method.
        Player player1 = getPlayer(Integer.parseInt(player1TextField.getText()));
        Player player2 = getPlayer(Integer.parseInt(player2TextField.getText()));
        Player winner = getPlayer(Integer.parseInt(winnerM1TextField.getText()));

        //Game from the database. Search by the id written in the "Game id" box in the program through getGame method.
        Game game = getGame(Integer.parseInt(gameTextFieldM1.getText()));

        //Following code not used to try another save method.
        Matchup1Vs1 newMatchup1Vs1 = new Matchup1Vs1(LocalDate.parse(matchup1vs1DateTextField.getText()), Integer.parseInt(player1ScoreTextField.getText()),
         Integer.parseInt(player2ScoreTextField.getText()), player1, player2, winner, game);

        saveMatchup1Vs1(newMatchup1Vs1);

        matchup1Vs1Table.getItems().setAll(getAllMatchup1Vs1s());

    }

    public void addGame(){
        Game newGame = new Game(gameNameColumn.getText());

        saveGame(newGame);
    }

    // Method created to get a player object that is created and add it to the constructor of the matchup1Vs1 and later a similar method
    // should be able to be created to make a teamVsTeam constructor..
    public Player getPlayer(int playerColumnId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        Player playerToGet = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            playerToGet = entityManager.find(Player.class, playerColumnId);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return playerToGet;
    }

    // Method to get Game based on the Game id from the database.
    public Game getGame(int gameColumnId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        Game gameToGet = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            gameToGet = entityManager.find(Game.class, gameColumnId);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return gameToGet;
    }


    // Same concept as the saveEmployee method.
    public void saveTeamPlayer(Country country, PostalAddress postalAddress, Address address, Person person, Game
            game, Team team, Player player) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(country);
            entityManager.persist(postalAddress);
            entityManager.persist(address);
            entityManager.persist(person);
            entityManager.persist(game);
            entityManager.persist(team);
            entityManager.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void saveSoloPlayer(Country country, PostalAddress postalAddress, Address address, Person person, Game
            game, Player player) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(country);
            entityManager.persist(postalAddress);
            entityManager.persist(address);
            entityManager.persist(person);
            entityManager.persist(game);
            entityManager.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void saveMatchup1Vs1(Matchup1Vs1 theMatchup1Vs1) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(theMatchup1Vs1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    public void saveGame(Game theGame){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(theGame);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    // Those 2 methods below aren't functioning properly. I couldn't figure out how to solve it.
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
  }


  // Those 2 methods below aren't functioning properly. I couldn't figure out how to solve it.

  public List<Player> getAllPlayers() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;
    List<Player> players = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      TypedQuery<Player> allPlayersQuery = entityManager.createQuery("from Player ", Player.class);
      players = allPlayersQuery.getResultList();
      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      entityManager.close();
    }

    // Method as follows created with above methods as pattern.
    public List<Matchup1Vs1> getAllMatchup1Vs1s() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Matchup1Vs1> matchup1Vs1s = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Matchup1Vs1> allMatchup1Vs1sQuery = entityManager.createQuery("from Matchup1Vs1 ", Matchup1Vs1.class);
            matchup1Vs1s = allMatchup1Vs1sQuery.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return matchup1Vs1s;
    }

    private List<Game> getAllGames() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Game> games = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Game> allGamesQuery = entityManager.createQuery("from Game ", Game.class);
            games = allGamesQuery.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return games;
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
