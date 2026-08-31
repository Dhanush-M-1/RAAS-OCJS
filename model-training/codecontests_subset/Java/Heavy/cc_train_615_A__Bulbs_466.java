import java.util.Arrays;
import java.util.Scanner;
 
public class Bulbs {
 
	// public static boolean equals(Object[] a, Object[] a2)
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int buttons = scan.nextInt();
		int numBulbs = scan.nextInt();
		boolean allOn = false;
		int temp = 0;
		int bulbs[] = new int[numBulbs];
		int yes[] = new int[numBulbs];
		int okay = 0;
 
		for (int i = 0; i < numBulbs; i++) {
			bulbs[i] = i + 1;
		}
 
		for (int i = 0; i < buttons; i++) {
			temp = scan.nextInt();
			for (int j = 0; j < temp; j++) {
				okay = scan.nextInt() - 1;
				bulbs[okay] = 0;
			}
		}
 
		// System.out.println(Arrays.toString(bulbs) + "\n" + Arrays.toString(yes));
 
		allOn = Arrays.equals(bulbs, yes);
 
		if (true == allOn) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
 
}