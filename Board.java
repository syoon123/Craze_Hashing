import java.util.*;
import java.io.*;

public class Board {
    // INSTANCE VARIABLES
    private int numCards = 0; // Tracks number of cards on the board.
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<ArrayList<Card>> board = new ArrayList<ArrayList<Card>>();

    // CONSTRUCTORS
    public Board() {
	board = new ArrayList<ArrayList<Card>>();
	for (int i = 0; i < 3; i++) // Makes a 3 row board
	    board.add(new ArrayList<Card>());
	generateDeck();             // Creates a deck
	shuffleDeck();              // Shuffles deck
	for (int i = 0; i < 3; i++) // Deals 9 cards
	    draw();
	resetNumCards();            // Resets NumCards to 9
    }
    
    // ACCESSORS AND MUTATORS
    public Card get(int row, int col) {
	return board.get(row).get(col);
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
    public void draw() { // there might be an issue with this??
	for (ArrayList<Card> al : board)
	    al.add(deck.remove(0));
	numCards += 3;
    }

    public void distribute() { // Can't test right now, don't have mechanism for selecting cards
	int rowLength = (numCards + 1)/3; // num of cards each row should have
	ArrayList<Card> stash = new ArrayList<Card>(); // temp storage of cards to be moved
	for (ArrayList<Card> al : board) {
	    if (al.size() > rowLength) { // chop off cards past average row size, store to be readded 
		for(Card b : al) {
		    stash.add(b); 
		}
	    }
	}
	for (ArrayList<Card> al : board) {
	    while (al.size()<rowLength) { // tack on cards until row reaches average size
		al.add(stash.remove(0)); // move cards from stash to new spots
	    }
	}	    
    }

    // METHODS - VERIFICATION
    public boolean setExists() {
	return false; // DO LATER
    }

    // METHODS - PRINT BOARD
    public String toString() { // there might be an issue with this??
	String retStr = "";
	for (int k=0; k<3; k++) {
	    String row = "";
	    for (int j=0; j<board.size(); j++) {
		row += get(j,k).toString(); // grow a row to display by iterating through board's columns
	    }
	    row += "\n";
	    retStr += row;
	}
	return retStr;
    }

    // TESTING
    public static void main(String [] args) {
	Board board = new Board();
	System.out.println(board);
	board.draw();
	System.out.println(board);
	// not sure why this gives the same 3x3 board twice
    }
}
