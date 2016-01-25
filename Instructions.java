// Class Instructions

import java.util.*;
import java.io.*;
import cs1.Keyboard;

public class Instructions {
    
    private Card[] shape;
    private Card[] color;
    private Card[] number;
    private Card[] shading;

    private Card[][] setExamples;
    private Card[][] notSets;

    private static void clear(){
        String clear = "\u001b[2J";
        String home = "\u001b[H";
        System.out.print(clear + home);
        System.out.flush();
    }
    
    public Instructions() {

	Card a = new Card(2,"red","O","()");
	Card b = new Card(2,"red","O","[]");
	Card c =new Card(2,"red","O","{}");
	Card d = new Card(1,"green","S","[]");
	Card e = new Card(2,"blue","O","[]");
	Card f = new Card(3,"red","X","[]");
	Card g  = new Card(1,"blue","O","[]");
	Card h = new Card(2,"green","X","{}");
	Card i = new Card(3,"red","S","()");
	setExamples = new Card[3][3];
	Card[] s1 = {a,b,c};
	Card[] s2 = {d,e,f};
	Card[] s3 = {g,h,i};
	setExamples[0]=s1;
	setExamples[1]=s2;
	setExamples[2]=s3;

	Card[] n1 = {d,c,f};
	Card[] n2 = {g,h,f};
	notSets = new Card[2][3];
	notSets[0]=n1;
	notSets[1]=n2;
	
	Card j = new Card(1,"red","O","{}");
	Card k = new Card(1,"red","S","{}");
	Card l = new Card(1,"red","X","{}");
	shape = new Card[3];
	shape[0]=j;
	shape[1]=k;
	shape[2]=l;

	Card m = new Card(1,"red","O","{}");
	Card n = new Card(1,"blue","O","{}");
	Card o = new Card(1,"green","O","{}");
	color = new Card[3];
	color[0]=m;
	color[1]=n;
	color[2]=o;

	Card p = new Card(1,"blue","S","{}");
	Card q = new Card(2,"blue","S","{}");
	Card r = new Card(3,"blue","S","{}");
	number = new Card[3];
	number[0]=p;
	number[1]=q;
	number[2]=r;

	Card s = new Card(3,"green","X","()");
	Card t = new Card(3,"green","X","[]");
	Card u = new Card(3,"green","X","{}");
	shading = new Card[3];
	shading[0]=s;
	shading[1]=t;
	shading[2]=u;

    }

    public String print1D(Card[] a) {
	String ret = "";
	for (Card c: a) {
	    ret += c.toString();
	}
	return ret;
    }

    public String print2D(Card[][] a) {
	String ret="";
	for (int i = 0; i<a.length; i++) {
	    ret += (i+1) + ") ";
	    ret += print1D(a[i]);
	    ret += "\n";
	}
	return ret;
    }

    public String[] printAll() {
	String[] ret = new String[4];

	String ret1 = "";
	ret1 += "\nThe objective of the game is to identify Sets of 3 cards\nfrom the cards placed on the board.\n";
	
	ret1 += "\nEvery card has four features, which can vary as follows:\n";
	ret1 += "Shape:   " + print1D(shape) + "\n";
	ret1 += "Color:   " + print1D(color) + "\n";
	ret1 += "Number:  " + print1D(number) + "\n";
	ret1 += "Shading: " + print1D(shading) + "\n";

	ret1 += "\nEnter \"n\" to continue.\n";
	ret[0] = ret1;

	String ret2 = "";
	ret2 += "\nA Set consists of 3 cards in which each of the cards’ features,\nlooked at one by one, are the same on each card or different\non each card. All of the features must separately satisfy this rule.\n";
	
	ret2 += "\nSome examples of Sets:\n";
	ret2 += print2D(setExamples) + "\n";
	ret2 += "These are NOT Sets:\n";
	ret2 += print2D(notSets);
	ret2 += "\nEnter \"n\" to continue.\n";

	ret[1] = ret2;
	
	String ret3 = "";
	ret3 += "\n9 cards are placed on the board. If there are no possible Sets,\n3 more cards will be dealt. To select 3 cards that you think\nmake a Set, type in their coordinates in the form \"A0 B0 C0\". Neither\ncapitalization nor whitespace matters.\n";
	ret3 += "\nIf your selection is a Set, the cards selected will be removed from\nthe board. There will always be at least 9 cards on the board,\nunless there are no more cards in the deck. You can manually\ndraw by typing \"D\" or \"d\". You are\nalso able to quit the game at any point by entering \"Q\" or \"q.\"\n";
	ret3 += "\nEnter \"n\" to continue.\n";
	ret[2] = ret3;

	String ret4 = "";
	ret4 += "\nFor Standard Mode, the game ends when the deck is depleted and\nthere are no more possible Sets on the board. Your score is the\naverage time you spent, in seconds, per correct Set.\n";
	ret4 += "\nFor Sprint Mode, the game ends after exactly 3 minutes. Your\nscore is the number of Sets you were able to find under this\ntime limit.\n";
	ret4 += "\nGood luck and happy Set finding!!\n\n";
	
	ret[3] = ret4;

	return ret;
    }
    
    public static void main(String[] args) throws IOException {
	Instructions instr = new Instructions();
	String[] p = instr.printAll();
	clear();
	System.out.print(p[0]);
	String input = Keyboard.readString();
	if (input.equals("n")) {
	    clear();
	    System.out.print(p[1]);
	}
	input = Keyboard.readString();
	if (input.equals("n")) {
	    clear();
	    System.out.print(p[2]);
	}
	input = Keyboard.readString();
	if (input.equals("n")) {
	    clear();
	    System.out.print(p[3]);
	}
    }
}
