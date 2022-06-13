package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Opis implements Initializable{

    @FXML
    private Button powrotDoMenu;

    @FXML
    ImageView imagePowrot;

    public Opis() throws FileNotFoundException {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //kod do obrazka na powrot do menu
        File lockFile = new File("images/LOGO_HCH_wieksze.jpg");
        Image lockImage = new Image(lockFile.toURI().toString());
        imagePowrot.setImage(lockImage);

        powrotDoMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Menu.fxml","Menu!!!!", null);
            }
        });


    }


    //FileReader fr = new FileReader("C:\\Users\\dawch\\OneDrive\\Pulpit\\makaoGra\\src\\sample\\projekt_zasady_JAVAZASADY.txt");

}
