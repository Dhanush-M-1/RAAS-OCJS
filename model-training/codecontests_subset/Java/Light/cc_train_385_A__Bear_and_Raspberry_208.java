import java.util.*;
import java.lang.*;


public class malina {
	public static void main (String args[]) {
		Scanner in = new Scanner (System.in);


		int n = in.nextInt();
		int c = in.nextInt();
		int a[] = new int[n];
		int max = -1;

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			if (i + 1 < n && a[i] - a[i + 1] > max) {
				max = a[i] - a[i + 1];
			}
		}

		if (max - c <= 0) {
			System.out.println (0);
		}
		else {
			System.out.println (max - c);
		}
	}
}