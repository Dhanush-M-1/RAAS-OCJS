import java.io.*;
import java.util.*;

public class RCC {

	Scanner in;
	static PrintWriter out;

	

	void solve() {
		int n = in.nextInt();
		char []s = in.next().toCharArray();
		for (int start = 0; start < n; start++) {
			for (int step = 1; step + start < n; step++) {
				
				int count = 0;
				for (int pos = start; pos < n; pos += step) {
					if (s[pos] != '*') {
						break;
					} else {
						count++;
					}
				}
				if (count >= 5) {
					out.println("yes");
					return;
				}
				
			}
		}
		out.println("no");
	}

	<T> void printArr(T a[]) {
		for (int i = 0; i < a.length; i++) {
			out.print(a[i] + " ");
		}
		out.println();
	}

	static void asserT(boolean e) {
		if (!e) {
			throw new Error();
		}
	}

	public void run() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		try {
			solve();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new RCC().run();
	}
}