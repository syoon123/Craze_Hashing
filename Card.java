public class Card {
    // INSTANCE VARIABLES
    private int num; //1, 2, or 3
    private String color; //red, blue, or green
    private String shape; //O, X, or S
    private String shading; //(), {}, or []

    // CONSTRUCTORS
    public Card(int n, String c, String p, String d) {
	this();
	num = n;
	shape = p;
	shading = d;

	if (c == "red") {color = "\u001B[31m";}
	else if (c == "blue") {color = "\u001B[34m";}
	else if (c == "green") {color = "\u001B[32m";}
	
    }
    public Card() {
	num = 1;
	shape = "X";
	shading = "[]";
	color = "\u001B[34m";
    }

    // ACCESSORS AND MUTATORS
    public int getNum() {
	return num;
    }
    public String getColor() {
	return color;
    }
    public String getShape() {
	return shape;
    }
    public String getShading() {
	return shading;
    }
    public String toString() {
	String retStr = "";
	for (int i=0; i<num; i++) {
	    retStr += shading.substring(0,1) + shape + shading.substring(1);
	}
	for (int y=0; y<=9-num*3; y++) {
	    retStr += " ";
	}
	return color + retStr +"\u001B[0m";
    }

    public boolean equals(Card c) {
	return (num==c.getNum()) &&
	    (color.equals(c.getColor())) &&
	    (shape.equals(c.getShape())) &&
	    (shading.equals(c.getShading()));
    }

    public int setNum(int n) {
	int ret = getNum();
	num = n;
	return ret;
    }
    public String setColor(String c) {
	String ret = getColor();
	if (c == "red") {color = "\u001B[31m";}
	else if (c == "blue") {color = "\u001B[34m";}
	else if (c == "green") {color = "\u001B[32m";}
	return ret;
    }
    public String setShading(String s) {
	String ret = getShading();
	shading = s;
	return ret;
    }
    public String setShape(String s) {
	String ret = getShape();
	shape = s;
	return ret;
    }

    // TESTING
    public static void main(String[] args) {
	String[] colors = {"red","blue","green"};
	String[] shapes = {"O","X","S"};
	String[] shadings = {"{}","()","[]"};
	System.out.println("\t A           B           C");
	for (int i=0; i<3; i++) {
	    System.out.print("\u001B[0m" + i + "\t ");
	    for (int x=0; x<3; x++) {
		int n = (int)( Math.random() * 3 );
		int c = (int)( Math.random() * 3 );
		int p = (int)( Math.random() * 3 );
		int d = (int)( Math.random() * 3 );
		Card a = new Card(n+1, colors[c], shapes[p], shadings[d]);
		System.out.print(a);
		for (int y=0; y<9-n*3; y++) {
		    System.out.print(" ");
		}
	    }
	    System.out.println();
	}
	System.out.println("\u001B[0m");
    }
		
}
