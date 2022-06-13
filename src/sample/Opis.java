package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Opis implements Initializable{

    @FXML
    private Button powrotDoMenu;

    public Opis() throws FileNotFoundException {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        powrotDoMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Menu.fxml","Menu!!!!", null);
            }
        });


    }

    //FileReader fr = new FileReader("C:\\Users\\dawch\\OneDrive\\Pulpit\\makaoGra\\src\\sample\\projekt_zasady_JAVAZASADY.txt");

}
