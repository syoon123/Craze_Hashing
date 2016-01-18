import java.util.*;
import java.io.*;

public class Algo {
    
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
    
    public static void main(String[] args) {
        int[] existingSet = new int[6]; // Locations of the cards that make up the set
        Board board = new Board(); // Should have a full deck.
        ArrayList<Card> cards = board.getBoardCards();
        
        System.out.println(board);
        // SET EXISTENCE ALGO HERE
        System.out.println(setExists(cards)); // There we go.
        
        
    }
}