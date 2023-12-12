/**
 * Sample Skeleton for 'mailRun.fxml' Controller Class
 */

package com.example.postman;

import com.example.postman.MyClass.DBFunc;
import com.example.postman.MyClass.Database;
import com.example.postman.MyClass.WWPies;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MailRun {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Mail"
    private TextArea Mail; // Value injected by FXMLLoader

    @FXML // fx:id="logrun"
    private TextField logrun; // Value injected by FXMLLoader

    @FXML // fx:id="titleMail"
    private TextField titleMail; // Value injected by FXMLLoader
    @FXML // fx:id="run"
    private Button run; // Value injected by FXMLLoader
    DBFunc dbFunc = new DBFunc();
    Connection conn = dbFunc.connection_BD(new Database().PORT, new Database().DATABASE,
            new Database().USER_NAME, new Database().PASSWORD);
    WWPies wwPies = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\saveLogin.properties");
    @FXML
    void runMail(ActionEvent event) {
        List<String> logins = dbFunc.readLogins(conn);
        boolean next = false;
        for (String login1 : logins){
            if (Objects.equals(login1, logrun.getText())) {
                next=true;
                break;
            }
        }
        if (next) {
            dbFunc.insertMail(conn, titleMail.getText(), wwPies.getElement("login"), logrun.getText(), Mail.getText());
            Stage stage = (Stage) run.getScene().getWindow();
            stage.close();
        }else JOptionPane.showMessageDialog(null, "Этого логина не существует!",
                "Ошибка логина!", JOptionPane.ERROR_MESSAGE);
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        Mail.setText("\n\nС уважением и наилудшими пожеланиями\n" + dbFunc.readFio(conn, wwPies.getElement("login")));
    }

}
