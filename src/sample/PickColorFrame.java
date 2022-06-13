package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PickColorFrame implements Initializable {

    @FXML
    private Button ButtonPik;

    @FXML
    private Button ButtonKaro;

    @FXML
    private Button ButtonKier;

    @FXML
    private Button ButtonTrefl;


    private Card.Color As = null;
    Boolean allow = false;
    PopUpp popUp;

    public PickColorFrame(){}
    public PickColorFrame(PopUpp pop) {
        popUp=pop;
    }

    public Card.Color choseColor(Card card) {
        if (card.getColor() == Card.Color.Joker) {//As
            //this.setResizable(false);
        }
        return card.getColor();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ButtonKaro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                alertt.setTitle("Wybrano kolor Karo");
                alertt.setHeaderText(null);
                alertt.setContentText("Wybrano kolor Karo!");
                alertt.showAndWait();
                /*
                As = Card.Color.Karo;
                Label message = new Label("Wybrano kolor Karo");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null,message);
                allow = true;
                popUp.declaredColor = Card.Color.Karo;
                popUp.startGame.setButtonIcons();
                popUp.ButtonBierzacaKarta.setGraphic( new javafx.scene.image.ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + popUp.game.getTopCardImage()))));
                popUp.game.setCardColor(Card.Color.Karo);
                //popUp.


                 */
            }
        });

        ButtonKier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                alertt.setTitle("Wybrano kolor Kier");
                alertt.setHeaderText(null);
                alertt.setContentText("Wybrano kolor Kier!");
                alertt.showAndWait();

                /*
                As = Card.Color.Kier;
                Label message = new Label("Wybrano kolor Kier");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null,message);
                allow = true;
                popUp.declaredColor = Card.Color.Kier;
                popUp.startGame.setButtonIcons();
                popUp.ButtonBierzacaKarta.setGraphic( new javafx.scene.image.ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + popUp.game.getTopCardImage()))));
                popUp.game.setCardColor(Card.Color.Kier);
                //popUp.


                 */
            }
        });

        ButtonPik.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                alertt.setTitle("Wybrano kolor Pik");
                alertt.setHeaderText(null);
                alertt.setContentText("Wybrano kolor Pik!");
                alertt.showAndWait();
                DBUtils.changeScene(event, "StartGame.fxml","Wybrana karta", null);

              /*
                As = Card.Color.Pik;
                Label message = new Label("Wybrano kolor Pik");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null,message);
                allow = true;
                popUp.declaredColor = Card.Color.Pik;
                popUp.startGame.setButtonIcons();
                popUp.ButtonBierzacaKarta.setGraphic( new javafx.scene.image.ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + popUp.game.getTopCardImage()))));
                popUp.game.setCardColor(Card.Color.Pik);

                //popUp.
*/
            }
        });

        ButtonTrefl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                alertt.setTitle("Wybrano kolor Trefl");
                alertt.setHeaderText(null);
                alertt.setContentText("Wybrano kolor Trefl!");
                alertt.showAndWait();
                /*
                As = Card.Color.Trefl;
                Label message = new Label("Wybrano kolor Trefl");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null,message);
                allow = true;
                popUp.declaredColor = Card.Color.Trefl;
                popUp.startGame.setButtonIcons();
                popUp.ButtonBierzacaKarta.setGraphic( new javafx.scene.image.ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + popUp.game.getTopCardImage()))));
                popUp.game.setCardColor(Card.Color.Trefl);
                //popUp.


                 */
            }
        });
    }

}
