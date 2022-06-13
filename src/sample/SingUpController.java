package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SingUpController implements Initializable {

    @FXML
    private Button button_signup;

    @FXML
    private Button button_log_in;

    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;

    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()){
                    DBUtils.signUpUser(event, tf_username.getText(), tf_password.getText());
                }else{
                    System.out.println("Proszę wypełnić wszystkie informacje");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Podaj wszystkie informacje, aby się zarejestrować!");
                    alert.show();
                }
            }
        });

        File brandingFile = new File("images/LewaStrona.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("images/LOGO_HCH.jpg");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);

        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"sample.fxml","Zaloguj się!",null);
            }
        });
    }
}
