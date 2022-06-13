package sample;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /*
    W talii znajdują się także dwa jokery – czerwony i czarny
    Każdy z kolorów posiada 10 kart numerowanych od 2 do 10, oraz  dodatkową kartę – As
    Oraz 3 figury: Walet  Dama  Król
    co daje 13 kart jednego koloru.
    w sumie 54 karty
    */

    private Card[] cards;
    private int cardsInDeck;

    public Deck(){
        cards = new Card[54];
    }

    public void reset(){                            //tasowanie kart
        Card.Color[] colors = Card.Color.values();
        cardsInDeck = 0;

        for(int i = 0; i < colors.length-1; i++){
            Card.Color color = colors[i];

            cards[cardsInDeck++] = new Card(color, Card.Value.getValue(0));
            //dodanie od 2 do 10 po 4 karty
            for(int j = 2; j < 10; j++){
                cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j));
                cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j));
            }
            //dodanie po 4: as dama krol jopek
            Card.Value[] values = new Card.Value[]{Card.Value.Jack, Card.Value.Queen, Card.Value.King, Card.Value.As};
            for(Card.Value value : values){
                cards[cardsInDeck++] = new Card(color, value);
                cards[cardsInDeck++] = new Card(color, value);
            }
        }
        //dodanie 2 jacki
        Card.Value[] values = new Card.Value[]{Card.Value.Joker};
        for(Card.Value value : values){
            for(int i = 0; i < 2; i++){
                cards[cardsInDeck++] = new Card(Card.Color.Joker, value);
            }
        }
    }
    public void replaceDeckWith(ArrayList<Card> cards){
        this.cards = cards.toArray(new Card[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }
    // prawda jesli sa karty w talii
    public boolean isEmpty(){
        return cardsInDeck == 0;
    }

    public void shuffle(){
        int n = cards.length;
        Random random = new Random();

        for(int i = 0; i < cards.length; i++){

            //  pobierz losowy indeks tablicy za bieżącym indeksem
            //  argumenty są wyłącznym wiązaniem zamień losowy element
            //  na obecny element
            int randomValue = i + random.nextInt(n - 1);
            Card randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }
    public Card drawCard() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Nie może dobrać karty, ponieważ w talii nie ma żadnych kart");
        }
        return cards[--cardsInDeck];
    }

    public ImageView drawCardImage() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Nie może dobrać karty, ponieważ talia jest pusta");
        }
        return new ImageView(cards[--cardsInDeck].toString() + ".png");
    }

    public Card[] drawCard(int n){
        if(n<0){
            throw new IllegalArgumentException("Musi dobrać dobre karty, ale próbuje dobrać" + n + "cards");
        }

        if(n>cardsInDeck){
            throw new IllegalArgumentException("Nie można dobierać " + n + "kart, ponieważ są tylko" + cardsInDeck + " karty.");
        }

        Card[] ret = new Card[n];

        for(int i = 0; i < 0; i++){
            ret[i]=cards[++cardsInDeck];
        }
        return ret;
    }
}

