package sample;

import javafx.scene.image.Image;

import java.util.Objects;

public class Card {

    enum Color{
        Pik, Kier, Trefl, Karo, Joker;
        //wino, czerwien, zoladz, dzwonek

        private static Color[] colors = Color.values();
        public static Color getColor(int i){
            return Color.colors[i];
        }
    }

    enum Value{
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, As, Joker;
        // Karty funkcyjne to asy, dwójki, czwórki, walety, damy, króle, joker.
        // Karty niefunkcyjne to zatem trojki, piątki, szóstki, siódemki, ósemki, dziewiątki, dziesiątki.

        private static Value[] values = Value.values();
        public static Value getValue(int i){
            return Value.values[i];
        }
    }

    private  Image image;
    private  Color color;
    private  Value value;

    public Card(Color color,  Value value){
        this.color = color;
        this.value = value;
        String karty = color + "_" + value + ".png";
        image = new Image("images/imagesCards/" +  karty );
    }

    public Image getImage() {
        return image;
    }

    public Color getColor(){
        return this.color;
    }

    public Value getValue(){
        return this.value;
    }

    public String toString(){
        return color + "_" + value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return color == card.color && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, value);
    }
}

