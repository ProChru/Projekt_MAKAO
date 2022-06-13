package sample;


import javafx.scene.image.ImageView;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private int currentPlayer; //obecny gracz
    private String[] playerIds;

    private Deck deck;
    private ArrayList<ArrayList<Card>> playerHand; //rozdanie gracza
    private ArrayList<Card> stockpile; //skladowanie

    private Card.Color validColor;
    private Card.Value validValue;

    boolean gameDirection;


    public Game(String[] pids) {
        deck = new Deck();
        deck.shuffle();
        stockpile = new ArrayList<Card>();

        playerIds = pids;
        currentPlayer = 0;
        gameDirection = false;

        playerHand = new ArrayList<ArrayList<Card>>();

        for (int i = 0; i < pids.length; i++) {
            ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(5)));
            playerHand.add(hand);
        }
    }

    public void start(Game game) {
        Card card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();

        if (card.getValue() == Card.Value.Two) {
            start(game);
        }

        if (card.getValue() == Card.Value.Four) {
            //Label message = new Label(playerIds[currentPlayer] + " byłeś pominięty!");
            //message.setFont(new Font("Arial", Font.BOLD, 48));
            //JOptionPane.showMessageDialog(null, message);

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }

        if (card.getValue() == Card.Value.As) {
            start(game);
        }

        if (card.getValue() == Card.Value.King) {
            start(game);
        }

        if (card.getValue() == Card.Value.Queen) {
            start(game);
        }

        if (card.getValue() == Card.Value.Jack) {
            start(game);
        }

        if (card.getValue() == Card.Value.Joker) {
            start(game);
        }

        stockpile.add(card);
    }

    public Card getTopCard() { //gorna karta
        return new Card(validColor, validValue);
    }

    //public Image getTopCardImagee(){
     //   return new Image(validColor+"_"+validValue+".png");
   // }

    public ImageView getTopCardImage() {
        return new ImageView(validColor + "_" + validValue + ".png");
    }

    public boolean isGameOver() {
        for (String player : this.playerIds) {
            if (hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }

    public String getPreviousPlayer(int i) {//poprzednigracz
        int index = this.currentPlayer - i;
        if (index == -1) {
            index = playerIds.length - 1;
        }
        return this.playerIds[index];
    }

    public String[] getPlayers() {
        return playerIds;
    }

    public ArrayList<Card> getPlayerHand(String pid) {
        int index = Arrays.asList(playerIds).indexOf(pid);
        return playerHand.get(index);
    }

    public int getPlayerHandSize(String pid) {
        return getPlayerHand(pid).size();
    }

    public Card getPlayerCard(String pid, int choice) {
        ArrayList<Card> hand = getPlayerHand(pid);
        return hand.get(choice);
    }

    public boolean hasEmptyHand(String pid) {
        return getPlayerHand(pid).isEmpty();
    }

    public boolean validCardPlay(Card card) {
        return card.getColor() == validColor || card.getValue() == validValue;
    }


    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException {
        if (this.playerIds[this.currentPlayer] != pid) {
            throw new InvalidPlayerTurnException("To nie jest " + pid + " tura", pid);
        }
    }

    public void submitDraw(String pid) throws InvalidPlayerTurnException {
        checkPlayerTurn(pid);
        if (deck.isEmpty()) {
            deck.replaceDeckWith((stockpile));
            deck.shuffle();
        }

        getPlayerHand(pid).add(deck.drawCard());
        if (gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        } else if (gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playerIds.length - 1;
            }
        }
    }

    public void setCardColor(Card.Color color) {
        validColor = color;
    }

    public void submitPlayerCard(String pid, Card card, Card.Color declaredColor)
            throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
        checkPlayerTurn(pid);

        ArrayList<Card> pHand = getPlayerHand(pid);

        if (!validCardPlay(card)) {
            if (card.getValue() == Card.Value.As) {
                validColor = card.getColor();
                validValue = card.getValue();
            }

            if (card.getColor() != validColor) {
                Label message = new Label("Invalid player move, expected color: " + validColor + " but got color " + card.getColor());
                message.setFont(new Font("Arial", Font.BOLD, 48));
                //OptionPane.showMessageDialog(null, message);
                throw new InvalidColorSubmissionException("Invalid player move, expected clor: " + validColor + " but got color " + card.getColor(), card.getColor(), validColor);
            } else if (card.getValue() != validValue) {
                Label message2 = new Label("Invalid player move, expected color: " + validValue + " but got color " + card.getValue());
                message2.setFont(new Font("Arial", Font.BOLD, 48));
                //OptionPane.showMessageDialog(null, message2);
                throw new InvalidValueSubmissionException("Invalid player move, expected color: " + validValue + " but got color " + card.getValue(), card.getValue(), validValue);
            }
        }

        pHand.remove(card);
        if (hasEmptyHand(this.playerIds[currentPlayer])) {
            Label message2 = new Label(this.playerIds[currentPlayer] + " won the game! Thank you for playing!");
            message2.setFont(new Font("Arial", Font.BOLD, 48));
            //OptionPane.showMessageDialog(null, message2);
            System.exit(0);
        }
        validColor = card.getColor();
        validValue = card.getValue();
        stockpile.add(card);

        if (gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        } else if (gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playerIds.length - 1;
            }
        }

        if (card.getValue() == Card.Value.As) {
            validColor = declaredColor;
        }

        if (card.getValue() == Card.Value.King) {
            pid = playerIds[currentPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            Label message = new Label(pid + " dobierasz 4 karty!");
        }

        if (card.getValue() == Card.Value.Two) {
            pid = playerIds[currentPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            Label message = new Label(pid + " dobierasz 2 karty!");
        }

        if (card.getValue() == Card.Value.Four) {
            Label message = new Label(playerIds[currentPlayer] + " byles pominiety!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            //OptionPane.showMessageDialog(null, message);
            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }
    }

    //Nieprawidłowy wyjątek tury gracza
    class InvalidPlayerTurnException extends Exception {
        String playerId;

        public InvalidPlayerTurnException(String message, String pid) {
            super(message);
            playerId = pid;
        }

        public String getPid() {
            return playerId;
        }
    }

    class InvalidColorSubmissionException extends Exception {
        private Card.Color actual;
        private Card.Color expected;


        public InvalidColorSubmissionException(String message, Card.Color actual, Card.Color expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }

    class InvalidValueSubmissionException extends Exception {
        private Card.Value expected;
        private Card.Value actual;

        public InvalidValueSubmissionException(String message, Card.Value actual, Card.Value expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }
}




