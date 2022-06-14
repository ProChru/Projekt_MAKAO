package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.DBUtils.changeScene;


public class Menuu implements Initializable{

        @FXML
        private ImageView lockImageView;

        @FXML
        private Button startMenu;

        @FXML
        private Button opisMenu;

        @FXML
        private Button rankingMenu;

        @FXML
        private Button wylogowanieMenu;

        @FXML
        private Button wyjscieMenu;


        @Override
        public void initialize(URL location, ResourceBundle resources) {

            File lockFile = new File("images/LOGO_HCH_wieksze.jpg");
            Image lockImage = new Image(lockFile.toURI().toString());
            lockImageView.setImage(lockImage);

            startMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DBUtils.changeScene(event, "StartGame.fxml","Makao gra karciana", null);
                }
            });

            opisMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DBUtils.changeScene(event, "Opis.fxml","Opis gry", null);
                }
            });

            rankingMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DBUtils.changeScene(event, "DodajGracza.fxml","Dodanie gracza", null);
                }
            });

            wylogowanieMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DBUtils.changeScene(event, "sample.fxml","Zaloguj się!", null);
                }
            });

            wyjscieMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alertt = new Alert (Alert.AlertType.ERROR);
                    alertt.setTitle("Wyjscie!!!");
                    alertt.setHeaderText("Wychodzisz z gry");
                    alertt.setContentText("EXIT!");
                    alertt.showAndWait();

                    Stage stage = (Stage) wyjscieMenu.getScene().getWindow();
                    stage.close();

                }
            });

        }

}


