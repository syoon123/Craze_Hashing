// Main Driver Class Set - Runs different game modes.

import java.util.*;
import java.io.*;

public class Set {
    private static final String LOGO =
	"\n   d888888o.   8 8888888888 8888888 8888888888" + "\n" +
	" .`8888:' `88. 8 8888             8 8888" + "\n" +
	" 8.`8888.   Y8 8 8888             8 8888" + "\n" +
	" `8.`8888.     8 8888             8 8888" + "\n" +
	"  `8.`8888.    8 888888888888     8 8888" + "\n" +
	"   `8.`8888.   8 8888             8 8888" + "\n" +
	"    `8.`8888.  8 8888             8 8888" + "\n" +
	"8b   `8.`8888. 8 8888             8 8888" + "\n" +
	"`8b.  ;8.`8888 8 8888             8 8888" + "\n" +
	" `Y8888P ,88P' 8 888888888888     8 8888\n";
    
    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
	playloop:
	while (true) { // Replay Loop
	    System.out.println(LOGO);
	    System.out.println("Choose an option:\n" +
			       "\t1. Play\n" +
			       "\t2. Instructions\n" +
			       "\t3. About\n" +
			       "\t4. Highscores\n" +
			       "\t5. Quit\n");

	    // Game Selection
	    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    while (true) { // Input Loop
		int _input = input.read();
		if (_input == 49) { // "1"
		    choosegame(input);
		    break;
		} else if (_input == 50) { // "2"
		    System.out.println("Instructions\n");
		} else if (_input == 51) { // "3"
		    System.out.println("About\n");
		} else if (_input == 52) { // "4" -- To Do Later
		    System.out.println("Scores\n");
		} else if (_input == 53) { // "5"
		    break playloop;
		}
		clearBuffer(input);
	    }

	    System.out.println("Would you like to play again? Y/N");
	    while (true) { // Play Again
		int _input = input.read();
		if (_input == 121 || _input == 89) // "Y" or "y"
		    continue playloop;
		if (_input == 110 || _input == 78) // "N" or "n"
		    break playloop;
	    }
	}
    }

    public static void choosegame(BufferedReader input) throws IOException {
	String[] args = new String[0];
	System.out.println("Please select a game mode:\n" +
			   "\t1. Standard\n" +
			   "\t2. Sprint\n");

	// Reader Input
	while (true) {
	    int _input = input.read();
	    if (_input == 49) { // "1"
	        Set1.main(args); // Standard Game Mode
		break;
	    } else if (_input == 50) { // "2"
	        Set2.main(args); // Sprint Game Mode
		break;
	    }
	}
    }

    public static void clearBuffer(BufferedReader input) throws IOException {
	while (input.ready())
	    input.read();
    }
}
