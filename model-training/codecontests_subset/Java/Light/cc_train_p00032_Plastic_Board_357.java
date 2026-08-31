import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
	Scanner scan = new Scanner(System.in);
	int a, b, c, numRectagle = 0, numLozenge = 0;
	String[] input;
	while (scan.hasNext()) {
	    input = scan.nextLine().split(",");
	    a = Integer.parseInt(input[0]);
	    b = Integer.parseInt(input[1]);
	    c = Integer.parseInt(input[2]);
	    if (a * a + b * b == c * c) {
		numRectagle++;
	    }
	    if (a == b) {
		numLozenge++;
	    }
	}
	System.out.println(numRectagle);
	System.out.println(numLozenge);
    }
}