package com.example.postman;

import com.example.postman.MyClass.DBFunc;
import com.example.postman.MyClass.Database;
import com.example.postman.MyClass.WWPies;
import com.example.postman.MyClass.WindowChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class MailAnswer {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="aftor"
    private Label aftor; // Value injected by FXMLLoader

    @FXML // fx:id="answer"
    private Button answer; // Value injected by FXMLLoader

    @FXML // fx:id="lTopic"
    private Label lTopic; // Value injected by FXMLLoader

    @FXML // fx:id="textMail"
    private TextArea textMail; // Value injected by FXMLLoader

    @FXML
    void answerMail(ActionEvent event) {
        new WindowChanger().newWind(event, "/com/example/postman/answer.fxml", "Ответное письмо");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        DBFunc func = new DBFunc();
        Connection conn = func.connection_BD(new Database().PORT, new Database().DATABASE,
                new Database().USER_NAME, new Database().PASSWORD);
        WWPies wwPiesId = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\index.properties");
        lTopic.setText(func.readTopic(conn,wwPiesId.getElement("id")));
        aftor.setText(func.readAfter(conn,wwPiesId.getElement("id")));
        textMail.setText(func.readMail(conn,wwPiesId.getElement("id")));
    }

}