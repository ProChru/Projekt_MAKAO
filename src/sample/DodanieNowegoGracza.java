package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import javax.swing.plaf.OptionPaneUI;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DodanieNowegoGracza implements Initializable {

    @FXML
    private Button powrotDoMenu;

    @FXML
    private Button zapiszButton;

    @FXML
    private Button gotoweButton;

    @FXML
    TextField nowyGraczText;

    @FXML
    Label nowyGracz;


    public ArrayList<String> playerIds;


    public void AddPlayerNames(){
        playerIds = new ArrayList<>();
    }

    public String[]getPids(){
        String[]pids = playerIds.toArray(new String[playerIds.size()]);
        return pids;
    }


    public void zapisanieButton(){
        if(nowyGraczText.getText().isEmpty()){
            Alert alertt = new Alert (Alert.AlertType.INFORMATION);
            alertt.setTitle("Okno informacyjne");
            alertt.setHeaderText(null);
            alertt.setContentText("Podaj imie!");
            alertt.showAndWait();
        }
        else{
            String name = nowyGraczText.getText().trim();
            playerIds.add(name);

            if(playerIds.size() == 1){
                nowyGracz.setText(playerIds.get(0));
            }
            if(playerIds.size() > 0 && playerIds.size() < 2){
                Alert alert = new Alert (Alert.AlertType.INFORMATION);//alert = nowy Alert ( Alert.AlertType. INFORMACJE );
                alert.setTitle("Okno informacyjne");//. setTitle ( "Okno informacyjne" );
                alert.setHeaderText(null);//. setHeaderText ( null );
                alert.setContentText("Sukceeeees Zapisano!");//. setContentText ( "Mam dla ciebie świetną wiadomość!" );
                alert.showAndWait();//.showAndWait();

                // Label message = new Label("Sukceeeees Zapisano");
            }
            if(playerIds.size() == 2){
                playerIds.remove(name);
                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setTitle("Okno informacyjne");
                alert.setHeaderText(null);
                alert.setContentText("Sukceeeees Zapisano!");
                alert.showAndWait();
            }
        }
    }

    public void setGotoweButton() throws IOException {
        if(playerIds.size() == 1){
            Alert alert = new Alert (Alert.AlertType.INFORMATION);//alert = nowy Alert ( Alert.AlertType. INFORMACJE );
            alert.setTitle("Okno informacyjne");//. setTitle ( "Okno informacyjne" );
            alert.setHeaderText(null);//. setHeaderText ( null );
            alert.setContentText("Sukceeeees Zapisano Gracza!");//. setContentText ( "Mam dla ciebie świetną wiadomość!" );
            alert.showAndWait();//.showAndWait();
        }
        else{
            //new StartGame(playerIds).setVisible(true);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        powrotDoMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Menu.fxml","Menu!!!!", null);
            }
        });



/*
        zapiszButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nowyGraczText.getText().isEmpty()){
                    Label message = new Label("Prosze o imie");
                }
                else{
                    String name = nowyGraczText.getText().trim();
                    playerIds.add(name);

                    if(playerIds.size() == 1){
                        nowyGracz.setText(playerIds.get(0));
                    }
                    if(playerIds.size() > 0 && playerIds.size() < 2){
                        Alert alert = new Alert (Alert.AlertType.INFORMATION);//alert = nowy Alert ( Alert.AlertType. INFORMACJE );
                        alert.setTitle("Okno informacyjne");//. setTitle ( "Okno informacyjne" );
                        alert.setHeaderText(null);//. setHeaderText ( null );
                        alert.setContentText("Sukceeeees Zapisano!");//. setContentText ( "Mam dla ciebie świetną wiadomość!" );
                        alert.showAndWait();//.showAndWait();

                       // Label message = new Label("Sukceeeees Zapisano");
                    }
                    if(playerIds.size() == 2){
                        playerIds.remove(name);
                        Alert alert = new Alert (Alert.AlertType.INFORMATION);
                        alert.setTitle("Okno informacyjne");
                        alert.setHeaderText(null);
                        alert.setContentText("Sukceeeees Zapisano!");
                        alert.showAndWait();
                    }
                }
            }
        });


 */
    }

}
