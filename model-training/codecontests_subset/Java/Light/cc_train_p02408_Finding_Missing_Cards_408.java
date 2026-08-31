import java.util.Scanner;
import java.lang.Math;
public class Main{
    public static String[] MARKS = {"S", "H", "C", "D"};
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = Integer.parseInt(scan.nextLine());
	boolean[][] cards = new boolean[4][14];
	for (int cnt = 0; cnt < n; cnt++) {
	    String input = scan.nextLine();
	    String[] sequence = input.split(" ");
	    String[] inputs = input.split(" ");
	    int number = Integer.parseInt(inputs[1]);
	    if (inputs[0].equals("S")) {
		cards[0][number] = true;
	    } else if (inputs[0].equals("H")) {
		cards[1][number] = true;
	    } else if (inputs[0].equals("C")) {
		cards[2][number] = true;
	    } else if (inputs[0].equals("D")) {
		cards[3][number] = true;
	    }
	}
	for (int i = 0; i < 4; i++) {
	    for (int j = 1; j < 14; j++) {
		if (!cards[i][j]) {
		    System.out.println(MARKS[i] + " " + j);
		}
	    }
	}
    }
}