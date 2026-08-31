import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Games {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 0;
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
			b[i] = scn.nextInt();
		}
		for (int j = 0; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				if (a[j] == b[k])
					count++;
				if (a[k] == b[j])
					count++;
			}
		}
		System.out.println(count);
	}

}
