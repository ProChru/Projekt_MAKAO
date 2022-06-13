package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StartGame implements Initializable{

    @FXML
    private Button powrotDoMenu;
    @FXML
    private ImageView imagePowrot;

    @FXML
    Button Button1;
    @FXML
    ImageView imageButton1;

    @FXML
    private Button Button2;
    @FXML
    private ImageView imageButton2;

    @FXML
    private Button Button3;
    @FXML
    private ImageView imageButton3;

    @FXML
    private Button Button4;
    @FXML
    private ImageView imageButton4;

    @FXML
    private Button Button5;
    @FXML
    private ImageView imageButton5;

    @FXML
    private Button Button6;
    @FXML
    private ImageView imageButton6;

    @FXML
    private Button Button7;
    @FXML
    private ImageView imageButton7;

    @FXML
    private Button Button8;
    @FXML
    private ImageView imageButton8;

    @FXML
    private Button Button9;
    @FXML
    private ImageView imageButton9;

    @FXML
    private Button Button10;
    @FXML
    private ImageView imageButton10;

    @FXML
    private Button Button11;
    @FXML
    private ImageView imageButton11;

    @FXML
    private Button ButtonDobierzKarte;

    @FXML
    private ImageView imageBierzacaKarta;

    @FXML
    private ImageView imageOdwroconaKarta;

    @FXML
    private Label textDobierzKarte;

    @FXML
    private Label twojeKarty;



    private DodanieNowegoGracza addPlayers = new DodanieNowegoGracza();
    ArrayList <String> temp = new ArrayList<>();
    String[] pids;
    Game game;
    ArrayList<ImageView> cardButtons = new ArrayList<ImageView>();
    //String[] cardIds = new String[54];
    StartGame startGame;




    public StartGame() throws IOException {}
    public StartGame(ArrayList<String> playerIds) throws IOException {


        temp = playerIds;
        pids = temp.toArray(new String[temp.size()]);
        game = new Game(pids);
        populateArrayList();
        game.start(game);
        setPidName();

        imageBierzacaKarta.setImage(new Image(String.valueOf(getClass().getResource("images/imagesCards/" + game.getTopCardImage()))));
        setButtonIcons();

    }



    public void populateArrayList(){
        cardButtons.add(imageButton1);
        cardButtons.add(imageButton2);
        cardButtons.add(imageButton3);
        cardButtons.add(imageButton4);
        cardButtons.add(imageButton5);
        cardButtons.add(imageButton6);
        cardButtons.add(imageButton7);
        cardButtons.add(imageButton8);
        cardButtons.add(imageButton9);
        cardButtons.add(imageButton10);
        cardButtons.add(imageButton11);
    }


    public void setButtonIcons(){
        //String listString = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
       // String[] cardNames = listString.split(",");
        //cardIds = new ArrayList<String>(Arrays.asList(cardNames));

        game.getTopCardImage();




      //  for(int i = 0; i < 54; i++){
      //      cardButtons.get(i).setImage(new Image(String.valueOf((getClass().getResource("images/imagesCards/" + cardIds[i] + ".png")))));
      //  }
       // for(int i = cardIds.length; i < cardButtons.size(); i++){
       //     cardButtons.get(i).setImage(null); //ustawia wszystkie ikony kart na puste
       // }
    }

    public void losowanie(ImageView imageView,ImageView imageView2){

        String[] cardIds = new String[54];
        cardIds[0] = "Pik_As";
        cardIds[1] = "Pik_King";
        cardIds[2] = "Pik_Queen";
        cardIds[3] = "Pik_Jack";
        cardIds[4] = "Pik_Ten";
        cardIds[5] = "Pik_Nine";
        cardIds[6] = "Pik_Eight";
        cardIds[7] = "Pik_Seven";
        cardIds[8] = "Pik_Six";
        cardIds[9] = "Pik_Five";
        cardIds[10] = "Pik_Four";
        cardIds[11] = "Pik_Three";
        cardIds[12] = "Pik_Two";
        cardIds[13] = "Trefl_As";
        cardIds[14] = "Trefl_King";
        cardIds[15] = "Trefl_Queen";
        cardIds[16] = "Trefl_Jack";
        cardIds[17] = "Trefl_Ten";
        cardIds[18] = "Trefl_Nine";
        cardIds[19] = "Trefl_Eight";
        cardIds[20] = "Trefl_Seven";
        cardIds[21] = "Trefl_Six";
        cardIds[22] = "Trefl_Five";
        cardIds[23] = "Trefl_Four";
        cardIds[24] = "Trefl_Three";
        cardIds[25] = "Trefl_Two";
        cardIds[26] = "Kier_As";
        cardIds[27] = "Kier_King";
        cardIds[28] = "Kier_Queen";
        cardIds[29] = "Kier_Jack";
        cardIds[30] = "Kier_Ten";
        cardIds[31] = "Kier_Nine";
        cardIds[32] = "Kier_Eight";
        cardIds[33] = "Kier_Seven";
        cardIds[34] = "Kier_Six";
        cardIds[35] = "Kier_Five";
        cardIds[36] = "Kier_Four";
        cardIds[37] = "Kier_Three";
        cardIds[38] = "Kier_Two";
        cardIds[39] = "Karo_As";
        cardIds[40] = "Karo_King";
        cardIds[41] = "Karo_Queen";
        cardIds[42] = "Karo_Jack";
        cardIds[43] = "Karo_Ten";
        cardIds[44] = "Karo_Nine";
        cardIds[45] = "Karo_Eight";
        cardIds[46] = "Karo_Seven";
        cardIds[47] = "Karo_Six";
        cardIds[48] = "Karo_Five";
        cardIds[49] = "Karo_Four";
        cardIds[50] = "Karo_Three";
        cardIds[51] = "Karo_Two";
        cardIds[52] = "Black_Joker";
        cardIds[53] = "Red_Joker";


        Random randomek = new Random();
        int a = randomek.nextInt(54);

        File Pliczki = new File("images/imagesCards/"+cardIds[a]+".png");
        Image imagus = new Image(Pliczki.toURI().toString());
        //imageBierzaca.setImage(imagus);
        imageView.setImage(imagus);
        Image imagus2 = new Image(Pliczki.toURI().toString());
        imageView2.setImage(imagus);

    }



    public void dobierzKarte(ActionEvent event){

        try{
            game.submitDraw(game.getCurrentPlayer());
        }
        catch(Game.InvalidPlayerTurnException ex){
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE,null,ex);
        }
        this.setPidName(game.getCurrentPlayer());
        this.setButtonIcons();
    }


   public void setPidName(){
        String currentPlayer = game.getCurrentPlayer();
       twojeKarty.setText(currentPlayer + "karty");
    }
    public void setPidName(String currentPlayer){
        twojeKarty.setText(currentPlayer + "karty");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] cardIds = new String[54];
        cardIds[0] = "Pik_As";
        cardIds[1] = "Pik_King";
        cardIds[2] = "Pik_Queen";
        cardIds[3] = "Pik_Jack";
        cardIds[4] = "Pik_Ten";
        cardIds[5] = "Pik_Nine";
        cardIds[6] = "Pik_Eight";
        cardIds[7] = "Pik_Seven";
        cardIds[8] = "Pik_Six";
        cardIds[9] = "Pik_Five";
        cardIds[10] = "Pik_Four";
        cardIds[11] = "Pik_Three";
        cardIds[12] = "Pik_Two";
        cardIds[13] = "Trefl_As";
        cardIds[14] = "Trefl_King";
        cardIds[15] = "Trefl_Queen";
        cardIds[16] = "Trefl_Jack";
        cardIds[17] = "Trefl_Ten";
        cardIds[18] = "Trefl_Nine";
        cardIds[19] = "Trefl_Eight";
        cardIds[20] = "Trefl_Seven";
        cardIds[21] = "Trefl_Six";
        cardIds[22] = "Trefl_Five";
        cardIds[23] = "Trefl_Four";
        cardIds[24] = "Trefl_Three";
        cardIds[25] = "Trefl_Two";
        cardIds[26] = "Kier_As";
        cardIds[27] = "Kier_King";
        cardIds[28] = "Kier_Queen";
        cardIds[29] = "Kier_Jack";
        cardIds[30] = "Kier_Ten";
        cardIds[31] = "Kier_Nine";
        cardIds[32] = "Kier_Eight";
        cardIds[33] = "Kier_Seven";
        cardIds[34] = "Kier_Six";
        cardIds[35] = "Kier_Five";
        cardIds[36] = "Kier_Four";
        cardIds[37] = "Kier_Three";
        cardIds[38] = "Kier_Two";
        cardIds[39] = "Karo_As";
        cardIds[40] = "Karo_King";
        cardIds[41] = "Karo_Queen";
        cardIds[42] = "Karo_Jack";
        cardIds[43] = "Karo_Ten";
        cardIds[44] = "Karo_Nine";
        cardIds[45] = "Karo_Eight";
        cardIds[46] = "Karo_Seven";
        cardIds[47] = "Karo_Six";
        cardIds[48] = "Karo_Five";
        cardIds[49] = "Karo_Four";
        cardIds[50] = "Karo_Three";
        cardIds[51] = "Karo_Two";
        cardIds[52] = "Black_Joker";
        cardIds[53] = "Red_Joker";


        Random randomek = new Random();

        int a = randomek.nextInt(54);
        int b = randomek.nextInt(54);
        int c = randomek.nextInt(54);
        int d = randomek.nextInt(54);
        int e = randomek.nextInt(54);
        File Pliczki1 = new File("images/imagesCards/"+cardIds[a]+".png");
        File Pliczki2 = new File("images/imagesCards/"+cardIds[b]+".png");
        File Pliczki3 = new File("images/imagesCards/"+cardIds[c]+".png");
        File Pliczki4 = new File("images/imagesCards/"+cardIds[d]+".png");
        File Pliczki5 = new File("images/imagesCards/"+cardIds[e]+".png");

        Image imagus1 = new Image(Pliczki1.toURI().toString());
        Image imagus2 = new Image(Pliczki2.toURI().toString());
        Image imagus3 = new Image(Pliczki3.toURI().toString());
        Image imagus4 = new Image(Pliczki4.toURI().toString());
        Image imagus5 = new Image(Pliczki5.toURI().toString());
        //dodatkowe karty
        File Pliczki11 = new File("images/imagesCards/"+cardIds[a+2]+".png");
        File Pliczki12 = new File("images/imagesCards/"+cardIds[b+2]+".png");
        File Pliczki13 = new File("images/imagesCards/"+cardIds[c+2]+".png");
        File Pliczki14 = new File("images/imagesCards/"+cardIds[d+2]+".png");

        Image imagus11 = new Image(Pliczki11.toURI().toString());
        Image imagus12 = new Image(Pliczki12.toURI().toString());
        Image imagus13 = new Image(Pliczki13.toURI().toString());
        Image imagus14 = new Image(Pliczki14.toURI().toString());


        //kod do obrazka na powrot do menu
        File lockFile = new File("images/LOGO_HCH_wieksze.jpg");
        Image lockImage = new Image(lockFile.toURI().toString());
        imagePowrot.setImage(lockImage);

        //kod do image karty tylu
        File backkarta = new File("images/CardBack.png");
        Image backImage = new Image(backkarta.toURI().toString());
        imageOdwroconaKarta.setImage(backImage);

        powrotDoMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Menu.fxml","Menu!!!!", null);
            }
        });
        populateArrayList();
      //  String listString = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
     //   String[] cardNames = listString.split(",");
    //    cardIds = new ArrayList<String>(Arrays.asList(cardNames));


     Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

              //  if (cardButtons.get(0) != null) {
               //     int index = 0;
              //      String cardId = cardButtons.get(0);
              //      PopUpp window = new PopUpp(cardId, game, index, cardButtons, startGame, imageBierzacaKarta);
             //   }

                   imageBierzacaKarta.setImage(imagus1);

                   if(imageButton1!=imageBierzacaKarta){
                       imageButton1.setImage(null);
                   }



               // DBUtils.changeScene(event, "PopUpp.fxml","Wybrana karta", null);
               //if(cardIds != null) {
                  // int index = 0;
                  // String cardId = cardIds[0];
                   //new PopUpp(cardId, game, index, cardButtons, startGame, imageBierzacaKarta);
               //}

            }
        });

     Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus2);
                if(imageButton2!=imageBierzacaKarta){
                    imageButton2.setImage(null);
                }

               /* if (cardIds.get(1) != null) {
                    int index = 1;
                    String cardId = cardIds.get(1);
                    PopUpp window = new PopUpp(cardId, game, index, cardButtons, startGame, imageBierzacaKarta);
                }

                */
            }
        });

        imageButton1.setImage(imagus1);
        imageButton2.setImage(imagus2);
        imageButton3.setImage(imagus3);
        imageButton4.setImage(imagus4);
        imageButton5.setImage(imagus5);

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus3);
                if(imageButton3!=imageBierzacaKarta){
                    imageButton3.setImage(null);
                }
            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus4);
                if(imageButton4!=imageBierzacaKarta){
                    imageButton4.setImage(null);
                }
            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus5);
                if(imageButton5!=imageBierzacaKarta){
                    imageButton5.setImage(null);
                }
            }
        });


        ButtonDobierzKarte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               //Label message = new Label(game.getCurrentPlayer() + "pobierz karte!");

                if(imageButton1 != null){
                    imageButton1.setImage(imagus11);
                }

                if(imageButton2 != null)
                {
                    imageButton2.setImage(imagus12);
                }

                if(imageButton3 != null){
                    imageButton3.setImage(imagus13);
                }

                if(imageButton4 != null)
                {
                    imageButton4.setImage(imagus14);
                }

                if(imageButton5 != null)
                {
                    imageButton5.setImage(imagus2);
                }


                //try{
               //     game.submitDraw(game.getCurrentPlayer());
               // }
               // catch(Game.InvalidPlayerTurnException ex){
               //     Logger.getLogger(Game.class.getName()).log(Level.SEVERE,null,ex);
               // }
                //this.setButtonIcons();

            }
        });

    }
}


