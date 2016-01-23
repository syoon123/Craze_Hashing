// Temp Class Set, so working Set.java doesn't get corrupted.

import java.util.*;
import java.io.*;

public class Set2 {
    // METHODS
    // helper method for checking if any attr is allsame or alldiff
    public static boolean checkAttr(Object a, Object b, Object c) {
	return (a.equals(b) && b.equals(c)) || // All same.
	    ((!(a.equals(b))) && // All different.
	     (!(b.equals(c))) &&
	     (!(c.equals(a))));
    }
    
    // SET VERIFICATION ALGORITHM
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

    // SCORE CALCULATION ALGORITHM - STANDARD GAME
    public static double calcScore(ArrayList<Long> times) {
	int size = times.size();
	if (size == 0) return 999.999;
	double totalTime = 0;
	for (Long time : times)
	    totalTime += (double)time; // Calculate total time taken
	double avgTime = totalTime / size; // Average time per set
	return avgTime / 1000; // Change from milliseconds to seconds
    }

    // SET EXISTENCE ALGORITHM
    public static boolean setExists(ArrayList<Card> cards) {
        int size = cards.size();
        for (int i = 0; i < size - 2; i++)
            for (int j = i+1; j < size - 1; j++)
                for (int k = j+1; k < size; k++)
                    if (Set.isSet(cards.get(i), cards.get(j), cards.get(k))) {
                        System.out.println(i + "\t" + j + "\t" + k); // Debugging
                        return true;
                    }
        return false;
    }

    // CLEAR CONSOLE
    private static void clear(){
        String clear = "\u001b[2J";
        String home = "\u001b[H";
        System.out.print(clear + home);
        System.out.flush();
    }
    
    // MAIN
    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
	// Variables
	Board board = new Board();
	ArrayList<Long> times = new ArrayList<Long>();
	long curTime = -1L;

	// Gameplay
	outerloop:
	while (board.getDeckSize() > 0 || setExists(board.getBoardCards())) { // Game Loop
	    System.out.println(board);
	    if (!setExists(board.getBoardCards())) {
		System.out.println("No possible sets: drawing...");
		board.drawAll();
		continue;
	    }
	    int[] check = new int[6]; // For Input Parsing
	    if (curTime < 0)
		curTime = System.currentTimeMillis(); // Timing for score.
	    parseloop:
	    while (true) { // Input Loop
		for (int i = 0; i < 6; i++)
		    check[i] = -1; // Default fill for parsing.
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		input.mark(1000);
		System.out.println("Please choose three cards: ");
		int index = 0; // Index for check
		while (!(input.ready())) { // While the reader has characters
		    while (index < 6) {
			int i = input.read();
			if (i == 68 || i == 100){
			    if (board.getDeckSize() > 0) {
				if (board.getBoardSize() >= 21)
				    System.out.println("Please do not overdraw!");
				else {
				    board.drawAll();
				    board.distribute();
				    System.out.println("Drawing more cards...");
				}
			    } else {
				System.out.println("There are no more cards in the deck!");
			    }
			    System.out.println(board);
			    continue parseloop;
			}
			if (i == 88 || i == 120) { // X or x
			    clear();
			    continue outerloop;
			}
			if (i == 81 || i == 113) { // Q or q
			    System.out.println("Good game, mate!");
			    break outerloop;
			}
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
			    continue;
			index++;
		    }
		    input.reset();
		    // System.out.println(input.ready()); // For Debugging, Checks if Buffer is Empty
		}
		// for (int i : check) System.out.print(i + " "); // For Debugging, Lists Cards to Check
		break;
	    } // End Input Loop
	    while (true) { // Set Verification Loop
		try {
		    // System.out.println(Arrays.toString(check)); // Debugging - Inputs
		    Card c1 = board.getCard(check[0],check[1]);
		    Card c2 = board.getCard(check[2],check[3]);
		    Card c3 = board.getCard(check[4],check[5]);
		    if (c1.equals(c2) || c2.equals(c3) || c3.equals(c1)) {
			System.out.println("Nope! You can't repeat cards!");
		    }
		    else {
			if (isSet(c1,c2,c3)) { // Is A Set
			    curTime = System.currentTimeMillis() - curTime; // Find time it took to find a set.
			    times.add(curTime);
			    System.out.println("Times: " + times + "\n" + "Time for last set:\t" + curTime); // Debugging
			    curTime = -1L;
			    System.out.println("Booyah!");
			    board.removeSet(check[0],check[1],
					    check[2],check[3],
					    check[4],check[5]);
			    if (board.resetNumCards() < 9) // Always more than 9 cards
				board.drawAll();
			    board.distribute();
			} else { // Not A Set
			    System.out.println("Nope!");
			}
		    }
		} catch (IndexOutOfBoundsException ex) {
		    System.out.println("ERROR: Please input valid cards!");
		}
		break;
	    } // End Set Verification Loop
	} // End Game Loop
	// Score Display

	System.out.println("\nGame over!");
	System.out.println("Score: " + calcScore(times) + " seconds per Set.");
	
	// Writing to High Scores
	ScoreParser sp = new ScoreParser("HighScores.txt");
    }
}
