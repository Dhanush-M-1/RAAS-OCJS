

import java.util.Scanner;

public class CF347B {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String line = keyboard.nextLine();
		String[] s = line.split("=");
		int n = Integer.parseInt(s[1].trim());
		int max = n;
		int min = 1;
		int nplus = 0, nminus = 0;
		for (char c : s[0].toCharArray()) {
			if (c == '+') {
				max += n;
				min++;
				nplus++;
			}
			else if (c == '-') {
				max--;
				min -= n;
				nminus++;
			}
		}
		if (max < n || n < min) {
			System.out.println("Impossible");
			return;
		}
		int[] a = new int[nplus];
		int[] b = new int[nminus + 1];
		for (int i = 0; i < Math.max(nplus, nminus); i++) {
			a[i % nplus]++;
			b[i % (nminus+1)]++;
		}
		System.out.print("Possible\n" + (n - b[b.length - 1]));
		int iplus = 0;
		int iminus = 0;
		for (char c : s[0].toCharArray()) {
			if (c == '+') {
				System.out.print(" + " + a[iplus++]);
			}
			else if (c == '-') {
				System.out.print(" - " + b[iminus++]);
			}
		}
		System.out.println(" = " + n);
	}
}
