import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));;
	StringTokenizer st;

	private void solution() throws IOException {
		String s = nextToken();
		int n = nextInt();
		s = s.toLowerCase();
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			char lol = s.charAt(i);
			String win = String.valueOf(lol);
			if ((int) (lol) < n + 97) {
				ans = ans + win.toUpperCase();
			} else {
				ans = ans + win.toLowerCase();
			}
		}
		System.out.println(ans);

	}

	String nextToken() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	Integer nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public static void main(String args[]) throws IOException {
		new D().solution();

	}

}