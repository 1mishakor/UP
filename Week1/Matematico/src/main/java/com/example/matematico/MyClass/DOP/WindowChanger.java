package com.example.matematico.MyClass.DOP;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WindowChanger {
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void newWind(ActionEvent event, String directory, String title){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(directory));
        try {
            loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(parent));
        stage.show();
        setStage(stage);
    }
    /*public void closeWind(String directory){
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(directory)));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public void doterWind(String directory, String title){
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(directory)));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            setStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
