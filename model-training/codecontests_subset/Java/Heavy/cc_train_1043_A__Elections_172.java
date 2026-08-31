import java.util.Scanner;
import java.util.Arrays;

public class p1043A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numStudents = scan.nextInt();
		int[] arr = new int[numStudents];
		int sumElodreip = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			sumElodreip += arr[i];
		}

		Arrays.sort(arr);
		// This sorts the array from least to greatest
		int ans = arr[numStudents - 1];
		// After sorting, this finds the highest value, which will be in position 4
		// The input positions are 0, 1, 2, 3, 4
		int sumAwruk = 0;

		while (true) {
			// True is equivalent to 1, False is equivalent to 0
			sumAwruk = 0;
			for (int i = 0; i < arr.length; i++) {
				sumAwruk += (ans - arr[i]);
				// Subtracts highest value from each number in the array to find Awruk's votes
			}
			if (sumAwruk > sumElodreip) {
				System.out.println(ans);
				break;
			} else {
				ans++;
				// If highest num doesn't work, it adds 1 and runs through again until statement is true
			}
		}
	}
}