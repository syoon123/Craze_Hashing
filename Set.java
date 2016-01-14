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
    public boolean isSet(Card a, Card b, Card c) {
	return false; // TO ADD
    }

    public double avgTime() {
	return -1;
    }

    // DIFFERENT VERSIONS OF GAME
    public void playTimeVersion() {

    }

    public void playSprintVersion() {

    }

    // MAIN
    public static void main(String[] args) throws IOException {
	while (true) { // Input Loop
	    BufferedReader input =
		new BufferedReader(new InputStreamReader(System.in));
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
    
    
