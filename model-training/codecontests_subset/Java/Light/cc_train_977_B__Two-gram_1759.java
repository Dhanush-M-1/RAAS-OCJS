import java.io.*;
import java.util.Scanner;

public class TwoGram {
	public static void main(String args[]) {
		int n;
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();

		String s = scan.next();

		int count = 0;
		String maxStr = s.substring(0, 2);;
		int max = 0;

		for (int i=0; i<n-1; i++) {
			String sub = s.substring(i, i+2);

			for (int j=i+1; j<n-1; j++) {
				if (sub.equals(s.substring(j, j+2))) {
					count++;
				}
				if (count>max || max == 0) {
					max = count;
					maxStr = sub;
				}
			}
			count = 0;
		}

		System.out.println(maxStr);
	}
}