import java.util.*;
import java.io.*;

public class Board {
    // INSTANCE VARIABLES
    private int numCards = 0; // Tracks number of cards on the board.
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList[] board = new ArrayList[0];

    // CONSTRUCTORS
    public Board() {
	board = new ArrayList[3];   // Makes a 3 row board
	generateDeck();             // Creates a deck
	for (int i = 0; i < 3; i++) // Deals 9 cards
	    draw();
	resetNumCards();            // Resets NumCards to 9
    }
    
    // ACCESSORS AND MUTATORS
    public Card get(int row, int col) {
	ArrayList getRow = board[row];
	return (Card)(getRow.get(col)); // Will this work?
    }
    public int resetNumCards() {
	int total = 0;
	for (ArrayList al : board)
	    total += al.size();
	return total;
    }

    // METHODS - DECK GENERATION
    // generateDeck() will generate a deck of all 81 set cards
    public void generateDeck() {
	for (int num : new int[]{1,2,3})
	    for (String color : new String[]{"red","blue","green"})
		for (String shape : new String[]{"O","S","X"})
		    for (String shading : new String[]{"()","{}","[]"})
			deck.add(new Card(num,color,shape,shading));
    }
    public void shuffleDeck() {
	for (int loops = 0; loops < 2; loops++) {
	    for (int i = 0; i < deck.size(); i++) {
		int swap = (int)(Math.random() * deck.size());
		deck.set(i, deck.set(swap, deck.get(i)));
	    }
	}
    }

    // METHODS - BOARD MANIPULATION
    // draw() means picking three new cards from the deck
    public void draw() {
	for (ArrayList al : board)
	    al.add(deck.remove(0));
    }

    // shiftLeft() and distribute() will arrange and make the board look nice
    public void shiftLeft() { // No longer needed
    }
    public void distribute() {
    }

    // METHODS - VERIFICATION
    public boolean setExists() {
	return false; // DO LATER
    }

    // METHODS - OTHER
    public String toString() {
	return "oof";
    }

    // TESTING
    public static void main(String [] args) {
	Board board = new Board();
    }
}
