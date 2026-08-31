
//normal
import java.util.*;
import java.lang.*;
import java.io.*;
// String Tokenizer

public class Main {
	public static void main(String[] args) {
		// code
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		while (t > 0) {
			t--;
			int a = scn.nextInt();
			int b = scn.nextInt();
			int c = scn.nextInt();
			long ans = 0;
			while (c > 0 && b > 0) {
				if (c - 2 < 0) {
					break;
				}
				c -= 2;
				b -= 1;
				ans += 3;
			}
			while (b > 0 && a > 0) {
				if (b - 2 < 0) {
					break;
				}
				b -= 2;
				a -= 1;
				ans += 3;
			}
			System.out.println(ans);
		}
	}
}
