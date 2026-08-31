import java.util.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n];
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		for (int i = 0; i < n; i++) {
			s[i] = sc.next();

			if (s[i].equals("AC")) {
				a++;
			} else if (s[i].equals("WA")) {
				b++;
			} else if (s[i].equals("TLE")) {
				c++;
			} else {
				d++;
			}
		}
		System.out.println("AC x " + a);
		System.out.println("WA x " + b);
		System.out.println("TLE x " + c);
		System.out.println("RE x " + d);
		sc.close();
	}

}