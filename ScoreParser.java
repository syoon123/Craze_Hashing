// Class ScoreParser, for modifying high scores text file

import java.util.*;
import java.io.*;

public class ScoreParser {
    // INSTANCE VARIABLES
    private int _key = 0; // 1 - Parse highest to lowest | -1 - Parse Lowest to Highest
    private String _buffer, _file;
    private String[] _newScore;
    private static final String delimiter1 = "\t"; // Name DL1 Score
    private static final String delimiter2 = ":"; // [Name Score] DL2 [Name2 Score2]
    private String[][] _scores;

    // METHODS
    public ScoreParser(String filename, String name, String score, int key)
	throws FileNotFoundException {
	_key = key;
    	_file = filename;
	_newScore = new String[]{name, score};
	
    	// Reading Algorithm -- Put into buffer.
    	try {
    	    _buffer = read(); // Reading the current highscores.
    	} catch (FileNotFoundException ex) {
    	    System.out.println("Creating high scores file in " + _file + "...");
    	    PrintWriter newFile = new PrintWriter(new File(_file));
    	    newFile.println(_newScore[0] + delimiter1 + _newScore[1]);
    	    newFile.close();
	    return; // Terminate early...?
    	}
    	
    	// Formatting Algorithm -- Interpret the buffer.
    	format(_newScore);

	// Writing Algorithm -- Write to the file.
	write();
    }
    // Parse buffer into ArrayList -- scores.

    public String read() throws FileNotFoundException {
	Scanner sc = new Scanner(new File(_file));
        String ret = "";
        while (sc.hasNext()) {
            ret += sc.nextLine() + delimiter2; // Must be different from delimiter in highscores file 
        }
	// System.out.println(ret); // Debugging
	return ret;
    }
    public void write() throws FileNotFoundException {
	PrintWriter pw = new PrintWriter(new File(_file));
	for (int i = 0; i < _scores.length; i++) {
	    pw.println(_scores[i][0] + delimiter1 + _scores[i][1]);
	}
	pw.close();
    }

    public void format(String[] newScore) { // Changes _buffer into _scores
	// Temporary
	String[] score = newScore;
	String[] scoreList = _buffer.split(delimiter2);
        ArrayList<String[]> temp = new ArrayList<String[]>();
        // System.out.println(scoreList.length); // Debugging

        for (int i = 0; i < scoreList.length; i++) {
            temp.add(scoreList[i].split(delimiter1));
        }
        // for (int i = 0; i < temp.size(); i++) System.out.println(Arrays.toString(temp.get(i))); // Debugging
        String[][] ret = new String[scoreList.length + 1][2]; // +1 for the new score.
	for (int i = 0; i < ret.length; i++) {
	    if (temp.size() == 0) {
		ret[i] = score;
	    } else if (compareStrings(score[1], temp.get(0)[1], _key) > 0) { // Score to be inserted is less
		ret[i] = score;
		for (int j = i + 1; j < ret.length; j++) // Populate with rest of highscores
		    ret[j] = temp.remove(0);
		break;
	    } else {
		ret[i] = temp.remove(0);
	    }
	}
	// for (int i = 0; i < ret.length; i++) System.out.println(Arrays.toString(ret[i])); // Debugging
        _scores = ret;
    }
    // Helper: Compare two Strings as doubles
    public static int compareStrings(String d1, String d2, int key) {
	double _d1 = Double.parseDouble(d1);
	double _d2 = Double.parseDouble(d2);
	if (_d1 > _d2)
	    return 1 * key;
	if (_d2 > _d1)
	    return -1 * key;
	return 0;
    }
}
