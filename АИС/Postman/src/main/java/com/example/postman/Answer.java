package com.example.postman;

import com.example.postman.MyClass.DBFunc;
import com.example.postman.MyClass.Database;
import com.example.postman.MyClass.WWPies;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class Answer {
    DBFunc dbFunc = new DBFunc();
    Connection conn = dbFunc.connection_BD(new Database().PORT, new Database().DATABASE,
            new Database().USER_NAME, new Database().PASSWORD);
    WWPies wwPies = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\saveLogin.properties");
    WWPies wwPiesId = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\index.properties");

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="answerButton"
    private Button answerButton; // Value injected by FXMLLoader

    @FXML // fx:id="textMail"
    private TextArea textMail; // Value injected by FXMLLoader

    @FXML
    void answer(ActionEvent event) {
        dbFunc.insertMail(conn, dbFunc.readTopic(conn, wwPiesId.getElement("id")),
                wwPies.getElement("login"), dbFunc.readAfterLogin(conn, wwPiesId.getElement("id")),
                textMail.getText());
        Stage stage = (Stage) answerButton.getScene().getWindow();
        stage.close();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        textMail.setText("\n\nС уважением и наилудшими пожеланиями\n" + dbFunc.readFio(conn, wwPies.getElement("login"))
        +"\n\nЭТО ПИСЬМО ОТВЕТ ПИСЬМУ НА ТЕМУ -> "+dbFunc.readTopic(conn, wwPiesId.getElement("id")));
    }
}