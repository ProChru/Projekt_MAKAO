package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_logout;

    @FXML
    private Button button_gra;

    @FXML
    private Label label_welcome;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    button_logout.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.changeScene(event, "sample.fxml","Zaloguj się!", null);
        }
    });

    button_gra.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.changeScene(event, "Menu.fxml","Menu!!!!", null);
        }
    });

    }

    public void setUserInformation(String username){
        label_welcome.setText("Witaj " + username + " jesteś zalogowany");
    }
}
