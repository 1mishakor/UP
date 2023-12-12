/**
 * Sample Skeleton for 'regin.fxml' Controller Class
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

public class Regin {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="login"
    private TextField login; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML
    void inProg(ActionEvent event) {
        DBFunc dbFunc = new DBFunc();
        Connection conn = dbFunc.connection_BD(new Database().PORT, new Database().DATABASE,
                new Database().USER_NAME, new Database().PASSWORD);
        List<String> logs = dbFunc.readLogins(conn);

        boolean accessLogin = false;
        for (String log : logs){
            if (Objects.equals(log, login.getText())){
                accessLogin=true;
                break;
            }
        }
        if (accessLogin){
            if (Objects.equals(password.getText(), dbFunc.readPassword(conn, login.getText()))){
                WWPies w = new WWPies("src\\main\\resources\\com\\example\\postman\\properties\\saveLogin.properties");
                w.writeProperty("login", login.getText());
                new WindowChanger().newWind(event, "/com/example/postman/listPersons.fxml", "Postman");
            }else JOptionPane.showMessageDialog(null, "Неверный пароль или логие!",
                    "Ошибка при введении пароля или логина!", JOptionPane.ERROR_MESSAGE);
        }else JOptionPane.showMessageDialog(null, "Неверный пароль или логие!",
                "Ошибка при введении пароля или логина!", JOptionPane.ERROR_MESSAGE);
    }

    @FXML
    void regProg(ActionEvent event) {
        new WindowChanger().newWind(event, "/com/example/postman/reg.fxml", "Регистрация");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {


    }

}