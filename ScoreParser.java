// Class ScoreParser, for modifying high scores text file

import java.util.*;
import java.io.*;

public class ScoreParser {
    // INSTANCE VARIABLES
    private String _buffer, _file, _name;
    private static final String delimiter1 = "\t"; // Name DL1 Score
    private static final String delimiter2 = ":"; // [Name Score] DL2 [Name2 Score2]
    private String[][] _scores;

    // METHODS
    public ScoreParser(String filename) throws FileNotFoundException {	
    	_file = filename;       
    	// Reading Algorithm -- Put into buffer.
    	try {
    	    _buffer = read(); // Reading the current highscores.
    	} catch (FileNotFoundException ex) {
    	    System.out.println("Creating high scores file in " + _file + "...");
    	    PrintWriter newFile = new PrintWriter(new File(_file));
    	    newFile.flush();
    	    newFile.close();
    	}
    	
    	// Formatting Algorithm -- Interpret the buffer.
    	format();
    	
    	// Testing
    	String test = "Testing\tSplitting\tCry\tEverytime";
    	System.out.println(Arrays.toString(test.split(delimiter1)));
    }
	// Parse buffer into ArrayList -- scores.

    public String read() throws FileNotFoundException {
	    Scanner sc = new Scanner(new File(_file));
        String ret = "";
        while (sc.hasNext()) {
            ret += sc.nextLine() + delimiter2; // Must be different from delimiter in highscores file 
        }
	    System.out.println(ret); // Debugging
	    return ret;
    }
    public String write() {
	return "";
    }
    
    public void format() { // Changes _buffer into _scores
        String[] scoreList = _buffer.split(delimiter2);
        ArrayList<String[]> temp = new ArrayList<String[]>();
        System.out.println(scoreList.length); // Debugging
        for (int i = 0; i < scoreList.length; i++) {
            System.out.println(scoreList[i]);
            System.out.println(Arrays.toString(((String)scoreList[i]).split("\t")));
            temp.add(scoreList[i].split(delimiter1));
        }
        for (int i = 0; i < temp.size(); i++) System.out.println(Arrays.toString(temp.get(i))); // Debugging
        System.out.println(temp.get(0).length);
        String[][] ret = new String[scoreList.length + 1][2]; // +1 for the new score.
        
        _scores = ret;
    }
}
