import java.util.*;
import java.io.*;

public class Board {
    // INSTANCE VARIABLES
    private int numCards = 0; // Tracks number of cards on the board.
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<ArrayList<Card>> board = new ArrayList<ArrayList<Card>>();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUV";
    
    // CONSTRUCTORS
    public Board() {
	board = new ArrayList<ArrayList<Card>>();
	for (int i = 0; i < 3; i++) // Makes a 3 row board
	    board.add(new ArrayList<Card>());
	generateDeck();             // Creates a deck
	shuffleDeck();              // Shuffles deck
	for (int i = 0; i < 3; i++) // Deals 9 cards
	    drawAll();
	resetNumCards();            // Resets NumCards to 9
    }
    
    // ACCESSORS AND MUTATORS
    public Card getCard(int row, int col) {
	return board.get(row).get(col);
    }
    public Card removeCard(int row, int col) {
	Card ret = board.get(row).remove(col);
	resetNumCards();
	return ret;
    }
    public ArrayList<Card> removeSet(int r1, int c1, int r2, int c2, int r3, int c3) {
	ArrayList<Card> ret = new ArrayList<Card>();
	int[][] indices = { {r1, c1}, {r2, c2}, {r3, c3} };
	for (int passes = 0; passes < 2; passes++)
	    for (int i = 2; i > 0; i--)
		if (indices[i][1] > indices[i-1][1]) {
		    int[] temp = indices[i];
		    indices[i] = indices[i-1];
		    indices[i-1] = temp; 
		}
	for (int[] a : indices) {
	    ret.add(removeCard(a[0], a[1]));
	}
	// for (int[] i : indices) System.out.println(Arrays.toString(i));
	distribute();
	return ret;
    }
    public ArrayList<Card> getDeckCards() {
	return deck;
    }
    public ArrayList<Card> getBoardCards() {
	ArrayList<Card> cards = new ArrayList<Card>();
	for (ArrayList<Card> al : board)
	    for (int i = 0; i < al.size(); i++)
		cards.add(al.get(i));
	return cards;
    }
    public int getDeckSize() {
	return deck.size();
    }
    public int getBoardSize() {
	return getBoardCards().size();
    }
    public int resetNumCards() {
	int total = 0;
	for (ArrayList al : board)
	    total += al.size();
	numCards = total;
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
    // drawAll() means picking three new cards from the deck
    public void drawTo(int row) {
	board.get(row).add(deck.remove(0));
	resetNumCards();
    }
    public void drawAll() {
	for (ArrayList<Card> al : board)
	    al.add(deck.remove(0));
	resetNumCards();
    }

    public void distribute() { 
	int rowLength = numCards / 3; // Number of Cards in each row.
	ArrayList<Card> stash = new ArrayList<Card>(); // Card Storage
	for (ArrayList<Card> al : board) // Cutting off the excess...
	    while (al.size() > rowLength)
		stash.add(al.remove(al.size()-1)); // Take off the last card.
	for (ArrayList<Card> al : board) // And distributing it.
	    while (al.size() < rowLength) // Tack on cards until row reaches correct size
		al.add(stash.remove(0)); // move cards from stash to new spots
    }
    
    // METHODS - PRINT BOARD
    public String toString() { // there might be an issue with this??
	String retStr = "\t";
	int size = board.get(0).size();
	for (int i = 0; i < size; i++)
	    retStr += i + "         "; // Column Headings (0 - 9)
	retStr += "\n";
	for (int row = 0; row < 3; row ++) {
	    retStr += ALPHABET.substring(row,row+1) + "\t"; // Row Headings
	    for (int col = 0; col < size; col++) {
		// retStr += row + "," + col + "\t"; // Debugging for Windows
		retStr += getCard(row, col).toString();
	    }
	    retStr += "\n";
	}
	return retStr;
    }

    // TESTING
    public static void main(String [] args) {
	Board board = new Board();
	System.out.println(board);
	board.drawAll();
	System.out.println(board);
	//System.out.println(board.getBoardCards());
	board.removeSet(0,0,0,1,0,2);
	System.out.println(board);
    }
}
