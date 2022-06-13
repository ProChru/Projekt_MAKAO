package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


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
    private Button Button1;
    @FXML
    private ImageView imageButton1;

    @FXML
    private Button Button2;
    @FXML
    public ImageView imageButton2;

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
    Game game;
    StartGame startGame;


    public StartGame() throws IOException {}
    public StartGame(ArrayList<String> playerIds) throws IOException {

        imageBierzacaKarta.setImage(new Image(String.valueOf(getClass().getResource("images/imagesCards/" + game.getTopCardImage()))));


    }
    public void funkcyjkiKart(int o){
        if(cards[o].getWybor()==0){
            funkcjaAs(cards[o].nazwa);
        }
        else if(cards[o].getWybor()==1){
            funkcjaKing(cards[o].nazwa);
        }
        else if(cards[o].getWybor()==2){
            funkcjaFour(cards[o].nazwa);
        }
        else if(cards[o].getWybor()==3){
            funkcjaTwo(cards[o].nazwa);
        }
        else if(cards[o].getWybor()==4){
            funkcjaJoker(cards[o].nazwa);
        }
        else{
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("karta niefunkcyjna ");
            alerttt.setHeaderText("Karta niefunkcyjna "+cards[o].nazwa);
            alerttt.showAndWait();
        }
    }

    public void alercikiKolorciki(int p)
    {
        if(cards[p].getWybory()==10){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Pik");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
        else if(cards[p].getWybory()==11){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Trefl");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
        else if(cards[p].getWybory()==12){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Kier");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
        else if(cards[p].getWybory()==13){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Karo");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
    }




   public void setPidName(){
        String currentPlayer = game.getCurrentPlayer();
       twojeKarty.setText(currentPlayer + "karty");
    }
    public void setPidName(String currentPlayer){
        twojeKarty.setText(currentPlayer + "karty");
    }

    public void funkcjaAs(String nazwa){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wybór koloru");
        alert.setHeaderText("Wybór "+nazwa +" doprowadził, że musisz wybrać kolor dla przeciwnika");
        alert.setContentText("Wybierz kolor: ");

        ButtonType buttonTypeKier = new ButtonType("Kier");
        ButtonType buttonTypePik = new ButtonType("Pik");
        ButtonType buttonTypeKaro = new ButtonType("Karo");
        ButtonType buttonTypeTrefl = new ButtonType("Trefl");
        ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeKier, buttonTypePik, buttonTypeKaro,buttonTypeTrefl, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeKier){
            Alert alertt = new Alert (Alert.AlertType.INFORMATION);
            alertt.setTitle("Twój wybór");
            alertt.setContentText("Wybrano kolor Kier!");
            alertt.showAndWait();
        } else if (result.get() == buttonTypePik) {
            Alert alertt = new Alert (Alert.AlertType.INFORMATION);
            alertt.setTitle("Twój wybór");
            alertt.setContentText("Wybrano kolor Pik!");
            alertt.showAndWait();
        } else if (result.get() == buttonTypeKaro) {
            Alert alertt = new Alert (Alert.AlertType.INFORMATION);
            alertt.setTitle("Twój wybór");
            alertt.setContentText("Wybrano kolor Karo!");
            alertt.showAndWait();
        } else if (result.get() == buttonTypeTrefl) {
            Alert alertt = new Alert (Alert.AlertType.INFORMATION);
            alertt.setTitle("Twój wybór");
            alertt.setContentText("Wybrano kolor Trefl!");
            alertt.showAndWait();
        } else {
        }
    }

    public void funkcjaFour(String nazwa){
        Alert alertt = new Alert (Alert.AlertType.ERROR);
        alertt.setTitle("Stop!!!");
        alertt.setHeaderText("Twój przeciwnik karta: "+nazwa+" zablokował Cię na jedną kolejkę");
        alertt.setContentText("Zostałeś pominięty!");
        alertt.showAndWait();
    }

    public void funkcjaKing(String nazwa){
        Alert alertt = new Alert (Alert.AlertType.INFORMATION);
        alertt.setTitle("Dobranie kart!");
        alertt.setHeaderText("Twój przeciwnik używa karty "+nazwa);
        alertt.setContentText("Musisz pobrać 4 karty!");
        alertt.showAndWait();
    }

    public void funkcjaTwo(String nazwa){
        Alert alertt = new Alert (Alert.AlertType.INFORMATION);
        alertt.setTitle("Dobranie kart!");
        alertt.setHeaderText("Twój przeciwnik używa karty "+nazwa);
        alertt.setContentText("Musisz pobrać 2 karty!");
        alertt.showAndWait();
    }

    public void funkcjaJoker(String nazwa){

        Alert alertt = new Alert (Alert.AlertType.CONFIRMATION);
        alertt.setTitle("Karta na wszystko!");
        alertt.setHeaderText("Użyłeś karty "+nazwa);
        alertt.setContentText("Możesz wybrać działanie kart funkcyjnych");

        ButtonType buttonTypeKing = new ButtonType("King");
        ButtonType buttonTypeTwo = new ButtonType("Two");
        ButtonType buttonTypeAs = new ButtonType("As");
        ButtonType buttonTypeFour = new ButtonType("Four");
        ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

        alertt.getButtonTypes().setAll(buttonTypeKing, buttonTypeTwo, buttonTypeAs,buttonTypeFour, buttonTypeCancel);
        String nazewka = "przez Joker";
        Optional<ButtonType> result = alertt.showAndWait();
        if (result.get() == buttonTypeKing){
            funkcjaKing(nazewka);
        } else if (result.get() == buttonTypeTwo) {
            funkcjaTwo(nazewka);
        } else if (result.get() == buttonTypeAs) {
            funkcjaAs(nazewka);
        } else if (result.get() == buttonTypeFour) {
            funkcjaFour(nazewka);
        } else {
        }
    }

    karty[] cards = new karty[12];

    int przydzialA(int a){
        int liczba = 100;
        if(a>=0&&a<=3)//As
            liczba=0;
        else if(a>3&&a<=7)//King
            liczba=1;
        else if(a>7&&a<=10)//Four
            liczba=2;
        else if(a>11&&a<=15)//Two
            liczba=3;
        else if(a>15&&a<=17)//Joker
            liczba=4;
        return liczba;
    }

    int przydzialKolor(int b){
        int essa = 200;
        if(b==0||b==4||b==8||b==12 ||b==24|| b==25 ||b== 26 ||b==27)
            essa=10;//Pik
        else if(b>36 &&b<=41)
            essa=10;//Pik
        else if(b==1||b==5||b==9||b==13 ||b==18 ||b==19 ||b==20 ||b==21 ||b==22||b==23)
            essa=11;//Trefl
        else if(b>50&&b<=53)
            essa=11;//Trefl
        else if(b==2||b==6||b==10||b==14 || b==28 ||b==29 ||b==30 ||b==31 ||b==32 ||b==33 ||b==34||b== 35 ||b==36)
            essa=12;//Kier
        else if(b==3||b==7||b==11||b==15 || b==42 ||b==43 ||b==44 ||b==45 ||b==46 ||b==47||b==48 ||b==49||b==50)
            essa=13;//Karo
        return essa;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] cardIds = new String[54];
        cardIds[0] = "Pik_As";
        cardIds[1] = "Trefl_As";
        cardIds[2] = "Kier_As";
        cardIds[3] = "Karo_As";
        cardIds[4] = "Pik_King";
        cardIds[5] = "Trefl_King";
        cardIds[6] = "Kier_King";
        cardIds[7] = "Karo_King";
        cardIds[8] = "Pik_Four";
        cardIds[9] = "Trefl_Four";
        cardIds[10] = "Kier_Four";
        cardIds[11] = "Karo_Four";
        cardIds[12] = "Pik_Two";
        cardIds[13] = "Trefl_Two";
        cardIds[14] = "Kier_Two";
        cardIds[15] = "Karo_Two";
        cardIds[16] = "Black_Joker";
        cardIds[17] = "Red_Joker";//koniec funkcji przedzialA
        cardIds[18] = "Trefl_Nine";
        cardIds[19] = "Trefl_Eight";
        cardIds[20] = "Trefl_Seven";
        cardIds[21] = "Trefl_Six";
        cardIds[22] = "Trefl_Five";
        cardIds[23] = "Trefl_Three";
        cardIds[24] = "Pik_Queen";
        cardIds[25] = "Pik_Jack";
        cardIds[26] = "Pik_Ten";
        cardIds[27] = "Pik_Nine";
        cardIds[28] = "Kier_Queen";
        cardIds[29] = "Kier_Jack";
        cardIds[30] = "Kier_Ten";
        cardIds[31] = "Kier_Nine";
        cardIds[32] = "Kier_Eight";
        cardIds[33] = "Kier_Seven";
        cardIds[34] = "Kier_Six";
        cardIds[35] = "Kier_Five";
        cardIds[36] = "Kier_Three";
        cardIds[37] = "Pik_Eight";
        cardIds[38] = "Pik_Seven";
        cardIds[39] = "Pik_Six";
        cardIds[40] = "Pik_Five";
        cardIds[41] = "Pik_Three";
        cardIds[42] = "Karo_Jack";
        cardIds[43] = "Karo_Ten";
        cardIds[44] = "Karo_Nine";
        cardIds[45] = "Karo_Eight";
        cardIds[46] = "Karo_Seven";
        cardIds[47] = "Karo_Six";
        cardIds[48] = "Karo_Five";
        cardIds[49] = "Karo_Three";
        cardIds[50] = "Karo_Queen";
        cardIds[51] = "Trefl_Queen";
        cardIds[52] = "Trefl_Jack";
        cardIds[53] = "Trefl_Ten";

        Random randomek = new Random();

        int a = randomek.nextInt(54);
        int b = randomek.nextInt(54);
        int c = randomek.nextInt(54);
        int d = randomek.nextInt(54);
        int e = randomek.nextInt(54);
        int f = randomek.nextInt(54);
        int g = randomek.nextInt(54);
        int h = randomek.nextInt(54);
        int i = randomek.nextInt(54);
        int j = randomek.nextInt(54);
        int k = randomek.nextInt(54);
        int l = randomek.nextInt(54);


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
        File Pliczki6 = new File("images/imagesCards/"+cardIds[f]+".png");
        File Pliczki7 = new File("images/imagesCards/"+cardIds[g]+".png");
        File Pliczki8 = new File("images/imagesCards/"+cardIds[h]+".png");
        File Pliczki9 = new File("images/imagesCards/"+cardIds[i]+".png");
        File Pliczki10 = new File("images/imagesCards/"+cardIds[j]+".png");
        File Pliczki11 = new File("images/imagesCards/"+cardIds[k]+".png");
        File Pliczki12 = new File("images/imagesCards/"+cardIds[l]+".png");

        Image imagus6 = new Image(Pliczki6.toURI().toString());
        Image imagus7 = new Image(Pliczki7.toURI().toString());
        Image imagus8 = new Image(Pliczki8.toURI().toString());
        Image imagus9 = new Image(Pliczki9.toURI().toString());
        Image imagus10 = new Image(Pliczki10.toURI().toString());
        Image imagus11 = new Image(Pliczki11.toURI().toString());
        Image imagus12 = new Image(Pliczki12.toURI().toString());

        cards[0]= new karty();
        cards[1]= new karty();
        cards[2]= new karty();
        cards[3]= new karty();
        cards[4]= new karty();
        cards[5]= new karty();//dodatkowe karty
        cards[6]= new karty();
        cards[7]= new karty();
        cards[8]= new karty();
        cards[9]= new karty();
        cards[10]= new karty();
        cards[11]= new karty();

        cards[0].setNazwa(cardIds[a]);
        cards[0].setWybor(przydzialA(a));
        cards[1].setNazwa(cardIds[b]);
        cards[1].setWybor(przydzialA(b));
        cards[2].setNazwa(cardIds[c]);
        cards[2].setWybor(przydzialA(c));
        cards[3].setNazwa(cardIds[d]);
        cards[3].setWybor(przydzialA(d));
        cards[4].setNazwa(cardIds[e]);
        cards[4].setWybor(przydzialA(e));
        cards[5].setNazwa(cardIds[f]);//dodatkowe karty
        cards[5].setWybor(przydzialA(f));
        cards[6].setNazwa(cardIds[g]);
        cards[6].setWybor(przydzialA(g));
        cards[7].setNazwa(cardIds[h]);
        cards[7].setWybor(przydzialA(h));
        cards[8].setNazwa(cardIds[i]);
        cards[8].setWybor(przydzialA(i));
        cards[9].setNazwa(cardIds[j]);
        cards[9].setWybor(przydzialA(j));
        cards[10].setNazwa(cardIds[k]);
        cards[10].setWybor(przydzialA(k));

        cards[0].setWybory(przydzialKolor(a));
        cards[1].setWybory(przydzialKolor(b));
        cards[2].setWybory(przydzialKolor(c));
        cards[3].setWybory(przydzialKolor(d));
        cards[4].setWybory(przydzialKolor(e));
        cards[5].setWybory(przydzialKolor(f));
        cards[6].setWybory(przydzialKolor(g));
        cards[7].setWybory(przydzialKolor(h));
        cards[8].setWybory(przydzialKolor(i));
        cards[9].setWybory(przydzialKolor(j));
        cards[10].setWybory(przydzialKolor(k));


        cards[11].setWybory(przydzialKolor(l));

        cards[11].setNazwa(cardIds[l]);



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

        imageButton1.setImage(imagus1);
        imageButton2.setImage(imagus2);
        imageButton3.setImage(imagus3);
        imageButton4.setImage(imagus4);
        imageButton5.setImage(imagus5);
        imageBierzacaKarta.setImage(imagus12);

     Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus1);
            }
        });


     Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus2);
            }
        });

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus3);

            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus4);

            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus5);

            }
        });

        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus6);

            }
        });

        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus7);

            }
        });

        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus8);

            }
        });

        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus9);

            }
        });

        Button10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus10);

            }
        });

        Button11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                imageBierzacaKarta.setImage(imagus11);

            }
        });

        ButtonDobierzKarte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Dobierz karty");
                alert.setHeaderText("Ile chcesz dobrac kart?");
                alert.setContentText("Wybierz ile: ");

                ButtonType buttonTypeJedna = new ButtonType("1 karte");
                ButtonType buttonTypeDwie = new ButtonType("2 karty");
                ButtonType buttonTypeTrzy = new ButtonType("4 karty");
                ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeJedna, buttonTypeDwie, buttonTypeTrzy, buttonTypeCancel);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeJedna){
                    Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                    alertt.setTitle("Dobierz karte");
                    alertt.setHeaderText("Dobrano jedna karte");
                    alertt.showAndWait();
                    imageButton7.setImage(imagus7);
                } else if (result.get() == buttonTypeDwie) {
                    Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                    alertt.setTitle("Dobierz 2 karty");
                    alertt.setHeaderText("Dobrano 2 karty");
                    alertt.showAndWait();
                    imageButton8.setImage(imagus8);
                    imageButton9.setImage(imagus9);
                } else if (result.get() == buttonTypeTrzy) {
                    Alert alertt = new Alert (Alert.AlertType.INFORMATION);
                    alertt.setTitle("Dobierz 4 karty");
                    alertt.setHeaderText("Dobrano 4 karty");
                    alertt.showAndWait();
                    imageButton8.setImage(imagus8);
                    imageButton9.setImage(imagus9);
                    imageButton10.setImage(imagus10);
                    imageButton11.setImage(imagus11);
                } else {
                }

            }
        });

    }
    public void buttonikBierzacy(MouseEvent mouseEvent) {

        if(cards[11].getWybory()==10){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Pik");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
        else if(cards[11].getWybory()==11){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Trefl");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
        else if(cards[11].getWybory()==12){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Kier");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
        else if(cards[11].getWybory()==13){
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("Karta o nieprawidlowym kolorze ");
            alerttt.setHeaderText("Karta koloru Karo");
            alerttt.setContentText("Musisz położyć ten sam kolor!");
            alerttt.showAndWait();
        }
    }




    public void buttonik1(MouseEvent mouseEvent) {

        //funkcyjkiKart(0);
        if(cards[0].getWybor()==0){
            funkcjaAs(cards[0].nazwa);
        }
        else if(cards[0].getWybor()==1){
            funkcjaKing(cards[0].nazwa);
        }
        else if(cards[0].getWybor()==2){
            funkcjaFour(cards[0].nazwa);
        }
        else if(cards[0].getWybor()==3){
            funkcjaTwo(cards[0].nazwa);
        }
        else if(cards[0].getWybor()==4){
            funkcjaJoker(cards[0].nazwa);
        }
        else{
            Alert alerttt = new Alert (Alert.AlertType.INFORMATION);
            alerttt.setTitle("karta niefunkcyjna ");
            alerttt.setHeaderText("Karta niefunkcyjna "+cards[0].nazwa);
            alerttt.showAndWait();
        }
        imageButton1.setImage(null);
        alercikiKolorciki(0);

    }
    public void buttonik2(MouseEvent mouseEvent) {

        funkcyjkiKart(1);
        imageButton2.setImage(null);
        alercikiKolorciki(1);
    }

    public void buttonik3(MouseEvent mouseEvent) {

        funkcyjkiKart(2);
        imageButton3.setImage(null);
        alercikiKolorciki(2);
    }

    public void buttonik4(MouseEvent mouseEvent) {


        funkcyjkiKart(3);
        imageButton4.setImage(null);
        alercikiKolorciki(3);
    }

    public void buttonik5(MouseEvent mouseEvent) {

        funkcyjkiKart(4);
        imageButton5.setImage(null);
        alercikiKolorciki(4);
    }
    public void buttonik6(MouseEvent mouseEvent) {

        funkcyjkiKart(5);
        imageButton6.setImage(null);
        alercikiKolorciki(5);
    }

    public void buttonik7(MouseEvent mouseEvent) {

        funkcyjkiKart(6);
        imageButton7.setImage(null);
        alercikiKolorciki(6);
    }



    public void buttonik8(MouseEvent mouseEvent) {

        funkcyjkiKart(8);
        imageButton8.setImage(null);
        alercikiKolorciki(7);
    }

    public void buttonik9(MouseEvent mouseEvent) {

        funkcyjkiKart(9);
        imageButton9.setImage(null);
        alercikiKolorciki(8);
    }

    public void buttonik10(MouseEvent mouseEvent) {

        funkcyjkiKart(9);
        imageButton10.setImage(null);
        alercikiKolorciki(9);
    }

    public void buttonik11(MouseEvent mouseEvent) {

        funkcyjkiKart(10);
        imageButton11.setImage(null);
        alercikiKolorciki(10);
    }
}


