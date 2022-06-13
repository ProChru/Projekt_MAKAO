package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PopUpp implements Initializable {


    @FXML
    private Button anulujKarte;

    @FXML
    private Button uzyjKarte;

    @FXML
    private Label cardLabel;

    @FXML
    public  ImageView wybranaKarta;

    String cardImage = "";
    Game game;
    ArrayList<Card> playerHand;
    int choice;
    ArrayList<ImageView> cardButtons;
    StartGame startGame;
    Button ButtonBierzacaKarta;
    Card.Color declaredColor;

   // public PopUpp(String cardId, Game game, int index, ArrayList<ImageView> cardButtons, StartGame startGame, ImageView imageBierzacaKarta){}

    public PopUpp(String cardName, Game game, int index, ArrayList<ImageView> cardButtons, StartGame startGame, ImageView buttonBierzacaKarta) {
            cardImage = cardName;
            this.game = game;
            playerHand = game.getPlayerHand(game.getCurrentPlayer());
            choice = index;
            this.cardButtons = cardButtons;
            cardLabel.setGraphic( new ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + cardImage + ".png"))));
            this.startGame = startGame;
            this.ButtonBierzacaKarta = ButtonBierzacaKarta;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //wybranaKarta.setImage(cardLabel);
        uzyjKarte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*PickColorFrame pickColor = new PickColorFrame(PopUpp.this);
                declaredColor = pickColor.choseColor(playerHand.get(choice));

                if(declaredColor != null)
                {
                    try{
                        game.submitPlayerCard(game.getCurrentPlayer(),playerHand.get(choice),declaredColor);
                    }
                    catch(Game.InvalidColorSubmissionException ex) {
                        Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE,null,ex);
                    }
                    catch(Game.InvalidValueSubmissionException ex) {
                        Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE,null,ex);
                    }
                    catch(Game.InvalidPlayerTurnException ex){
                        Logger.getLogger(PopUpp.class.getName()).log(Level.SEVERE,null,ex);
                    }
                    if(declaredColor != Card.Color.Joker){//As
                        ButtonBierzacaKarta.setGraphic(new ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + game.getTopCardImage()))));
                    }
                }
                 */
                ButtonBierzacaKarta.setGraphic(new ImageView(String.valueOf(getClass().getResource("images/imagesCards/" + game.getTopCardImage()))));
                //DBUtils.changeScene(event, "StartGame.fxml","Makao gra karciana", null);
            }
        });

        anulujKarte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) anulujKarte.getScene().getWindow();
                stage.close();
                DBUtils.changeScene(event, "StartGame.fxml","Makao gra karciana", null);
            }
        });
       
    }
}
