/**
 * Sample Skeleton for 'reg.fxml' Controller Class
 */

package com.example.postman;

import com.example.postman.MyClass.DBFunc;
import com.example.postman.MyClass.Database;
import com.example.postman.MyClass.WWPies;
import com.example.postman.MyClass.WindowChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Reg {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="familiya"
    private TextField familiya; // Value injected by FXMLLoader

    @FXML // fx:id="login"
    private TextField login; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TextField name; // Value injected by FXMLLoader

    @FXML // fx:id="otchestvo"
    private TextField otchestvo; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private TextField password; // Value injected by FXMLLoader

    @FXML // fx:id="paswordPovtor"
    private PasswordField paswordPovtor; // Value injected by FXMLLoader

    @FXML
    void zareg(ActionEvent event) {
        DBFunc db = new DBFunc();
        Connection conn = db.connection_BD(new Database().PORT, new Database().DATABASE,
                new Database().USER_NAME, new Database().PASSWORD);
        if (familiya.getText() != "" || name.getText()!= "" || otchestvo.getText()!= "" ||
                login.getText()!= "" || password.getText()!= ""|| paswordPovtor.getText()!= "") {
            List<String> logins = db.readLogins(conn);
            boolean next = true;
            for (String login1 : logins){
                if (Objects.equals(login1, login.getText())) {
                    next=false;
                    break;
                }
            }
            if (next) {
                if (Objects.equals(password.getText(), paswordPovtor.getText())) {
                    db.insertClient(conn, familiya.getText(), name.getText(), otchestvo.getText(),
                            login.getText(), password.getText());
                    WWPies w = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\saveLogin.properties");
                    w.writeProperty("login", login.getText());
                    new WindowChanger().newWind(event, "/com/example/postman/listPersons.fxml", "Postman");
                } else JOptionPane.showMessageDialog(null, "Повторите ещё раз или измените пароль!",
                            "Ошибка при повторении пароля!", JOptionPane.ERROR_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "Ваш логин уже кем-то используется!",
                    "Ошибка логина!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

}
