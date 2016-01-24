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
	System.out.println(LOGO);
	System.out.println("Choose an option:\n" +
			   "\t1. Play\n" +
			   "\t2. Instructions\n" +
			   "\t3. About\n");

	// Game Selection
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	input.mark(1000);
	while (true) { // Input Loop
	    if (input.read() == 49) { // "1"
		break;
	    } else if (input.read() == 50) { // "2"
		System.out.println("Instructions\n");
		input.reset();
	    } else if (input.read() == 51) { // "3"
		System.out.println("About\n");
		input.reset();
	    }
	}
	
	// Standard Game Mode
	Set1.main(args);

	// Sprint Mode
	Set2.main(args);
    }
}
