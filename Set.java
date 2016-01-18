// Class Set, acts as driver for the game.

import java.util.*;
import java.io.*;

public class Set {
    // INSTANCE VARIABLES
    // I don't think we need this, to be honest.
    // Maybe we can try implementing interfaces with different game modes?
    // for "time per set" version of game
    private ArrayList<Double> times = new ArrayList<Double>();

    // for "sprint" version of game
    private double timeLimit;
    private int numSets;

    // METHODS

    //helper method for checking if any attr is allsame or alldiff
    public static boolean checkAttr(Object a, Object b, Object c) {
	return (a.equals(b) && b.equals(c)) || // All same.
	    ((!(a.equals(b))) && // All different.
	     (!(b.equals(c))) &&
	     (!(c.equals(a))));
    }
    
    public static boolean isSet(Card a, Card b, Card c) {
	Integer[] nums = { (Integer)a.getNum(), (Integer)b.getNum(), (Integer)c.getNum() };
	String[] shapes = { a.getShape(), b.getShape(), c.getShape() };
	String[] colors = { a.getColor(), b.getColor(), c.getColor() };
	String[] shadings = { a.getShading(), b.getShading(), c.getShading() };

	boolean checkNums = checkAttr(nums[0],nums[1],nums[2]);
	boolean checkShapes = checkAttr(shapes[0],shapes[1],shapes[2]);
	boolean checkColors = checkAttr(colors[0],colors[1],colors[2]);
	boolean checkShadings = checkAttr(shadings[0],shadings[1],shadings[2]);

	return checkNums && checkShapes && checkColors && checkShadings;
    }

    public static boolean setExists(ArrayList<Card> cards) {
        int size = cards.size();
        for (int i = 0; i < size - 2; i++)
            for (int j = i+1; j < size - 1; j++)
                for (int k = i+2; k < size; k++)
                    if (Set.isSet(cards.get(i), cards.get(j), cards.get(k))) {
                        System.out.println(i + "\t" + j + "\t" + k); // Debugging
                        return true;
                    }
        return false;
    }

    public double avgTime() {
	return -1;
    }

    // DIFFERENT VERSIONS OF GAME: Subject to change, interface??
    public void playTimeVersion() {

    }

    public void playSprintVersion() {

    }

    // MAIN
    public static void main(String[] args) throws IOException {
	while (true) { // Input Loop
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    input.mark(1000);
	    System.out.println("Please choose three cards: ");
	    
	    int[] check = new int[6];
	    int index = 0;
	    while (!(input.ready())) { // While the reader has characters
		while (index < 6) {
		    int i = input.read();
		    if (i < 48) // Button presses, not useful for parsing.
			continue;
		    else if (i < 58) // 0 to 9
			check[index] = i - 48;
		    else if (i == 65 || i == 97) // A or a
			check[index] = 0; // 1?
		    else if (i == 66 || i == 98) // B or b
			check[index] = 1; // 2?
		    else if (i == 67 || i == 99) // C or c
			check[index] = 2; // 3?
		    else
			check[index] = -1;
		    index++;
		}
		input.reset();
		// System.out.println(input.ready()); // For Debugging, Checks if Buffer is Empty
	    }
	    for (int i : check)
		System.out.print(i + " "); // For Debugging, Lists Cards to Check

	    // SET VERIFICATION HERE
	    // BOARD MODIFICATION HERE
	}
    }
}
    
    
