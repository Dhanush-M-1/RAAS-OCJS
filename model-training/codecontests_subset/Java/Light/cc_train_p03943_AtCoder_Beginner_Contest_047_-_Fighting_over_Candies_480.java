import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int[] IntArray = new int[3];
		
		for (int i = 0; i < 3; i++) {
			int a = stdIn.nextInt();
		    IntArray[i] = a;
		}
		
		Arrays.sort(IntArray);
		
		if (IntArray[0] + IntArray[1] == IntArray[2]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}