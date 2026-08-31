import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		int numBtns = scan.nextInt();
		int numBulbs = scan.nextInt();
		boolean on = false;
		int alanna;
		
		int bulbs[] = new int[numBulbs];
		int alanna2[] = new int[numBulbs];
		
		for (int i = 0; i < numBulbs; i++) {
		    bulbs[i] = i + 1;
		}
		for (int i =  0; i < numBtns; i++) {
		    int input = scan.nextInt();
		    for (int j = 0; j < input; j++) {
		        alanna = scan.nextInt() - 1;
		        bulbs[alanna] = 0;
		    }
		}
		on = Arrays.equals(bulbs, alanna2);
		
		if (true == on) {
		    System.out.println("YES");
		} else {
		    System.out.println("NO");
		}
	}
}
