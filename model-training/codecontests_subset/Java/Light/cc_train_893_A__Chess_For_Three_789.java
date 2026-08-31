import java.util.*;
import java.io.*;

public class A893 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("cf.in"));
		
		int n = Integer.parseInt(in.readLine());

		int win = Integer.parseInt(in.readLine());
		if (win == 3) {
			System.out.println("NO"); return;
		}

		int lose = win == 1 ? 2 : 1;

		for (int i = 1; i < n; i++) {
			int next = Integer.parseInt(in.readLine());
			if (next == lose) {
				System.out.println("NO"); return;
			}
			lose = next == win ? 3 - (3 ^ win ^ lose) : win;
			win = next;
		}

		System.out.println("YES");
	}
}