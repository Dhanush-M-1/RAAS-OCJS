import java.io.*;
import java.util.*;

public class Main {
	static Scanner in;
	static PrintWriter out;
	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		int count = 0;
		for (int i = 0; i <= a; i += 2)
			for (int j = 0; j <= c; j++)
				if (n - (i >> 1) - (j << 1) >= 0 && n - (i >> 1) - (j << 1) <= b) {
					count++;
//					out.println(i + " " + (n - i/2 - j*2) + " " + j);
				}
		out.println(count);
		
		out.close();
	}
}