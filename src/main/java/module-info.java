module com.example.project_golf_piper_games {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;

    opens com.example.project_golf_piper_games.Classes;
    exports com.example.project_golf_piper_games;
    opens com.example.project_golf_piper_games to javafx.fxml;
}