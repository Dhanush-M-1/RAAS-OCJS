import java.util.ArrayList;
import java.util.Scanner;

public class A_Bear_and_Raspberry {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		int c = input.nextInt();
		int[] arr = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1])
				if (arr[i] - arr[i + 1] > max)
					max = arr[i] - arr[i + 1];
		}
		if (max > c)
			System.out.println(max - c);
		else
			System.out.println(0);
	}
}