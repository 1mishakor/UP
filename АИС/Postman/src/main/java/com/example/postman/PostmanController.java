/**
 * Sample Skeleton for 'listPersons.fxml' Controller Class
 */

package com.example.postman;

import com.example.postman.MyClass.DBFunc;
import com.example.postman.MyClass.Database;
import com.example.postman.MyClass.WWPies;
import com.example.postman.MyClass.WindowChanger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class PostmanController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="listP"
    private ListView<String> listP; // Value injected by FXMLLoader
    DBFunc dbFunc = new DBFunc();
    Connection conn = dbFunc.connection_BD(new Database().PORT, new Database().DATABASE,
            new Database().USER_NAME, new Database().PASSWORD);
    WWPies wwPies = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\listIdMail.properties");
    WWPies wwPiesLog = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\saveLogin.properties");
    @FXML
    void IncomingBut(ActionEvent event) {
        listP.setItems(dbFunc.readSend(conn, wwPiesLog.getElement("login")));
        listP.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WWPies wwPiesId = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\index.properties");
                //String id = String.valueOf(listP.getSelectionModel().getSelectedIndex());
                //System.out.println(wwPies.getElement(id));
                wwPiesId.writeProperty("id", wwPies.getElement(String.valueOf(listP.getSelectionModel().getSelectedIndex())));
                new WindowChanger().doterWind("/com/example/postman/mailAnswer.fxml", "Полученное письмо");
            }
        });
    }

    @FXML
    void sentBut(ActionEvent event) {
        listP.setItems(dbFunc.readRecipient(conn, wwPiesLog.getElement("login")));
        listP.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WWPies wwPiesId = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\index.properties");
                //String id = String.valueOf(listP.getSelectionModel().getSelectedIndex());
                //System.out.println(wwPies.getElement(id));
                wwPiesId.writeProperty("id", wwPies.getElement(String.valueOf(listP.getSelectionModel().getSelectedIndex())));
                new WindowChanger().doterWind("/com/example/postman/mailAnswer.fxml", "Полученное письмо");
            }
        });
    }
    @FXML
    void writeLine(ActionEvent event) {
        new WindowChanger().doterWind("/com/example/postman/mailRun.fxml", "Написать письмо");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        listP.setItems(dbFunc.readSend(conn, wwPiesLog.getElement("login")));

        listP.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WWPies wwPiesId = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\index.properties");
                //String id = String.valueOf(listP.getSelectionModel().getSelectedIndex());
                //System.out.println(wwPies.getElement(id));
                wwPiesId.writeProperty("id", wwPies.getElement(String.valueOf(listP.getSelectionModel().getSelectedIndex())));
                new WindowChanger().doterWind("/com/example/postman/mailAnswer.fxml", "Полученное письмо");
            }
        });
    }

}