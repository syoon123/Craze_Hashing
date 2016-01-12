import java.util.*;
import java.io.*;

public class Board {
    private ArrayList<Card> deck;
    private ArrayList[] board;

    public void generateDeck() {
    }

    public void shuffleDeck() {
    }

    public Board() {
	board = new ArrayList[3];
    }

    public Card get(int row, int col) {
	return new Card();
    }

    //draw() means picking three new cards from the deck
    public void draw() {
    }

    //shiftLeft() and distribute() are for arranging the board nicely after card selection
    public void shiftLeft() {
    }
    public void distribute() {
    }

    public boolean setExists() {
	return false;
    }

    public String toString() {
	return "oof";
    }

    // TESTING
    public static void main(String [] args) {
	Board board = new Board();
    }
}
