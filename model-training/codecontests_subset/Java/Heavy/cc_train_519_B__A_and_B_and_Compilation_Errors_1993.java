import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF519B {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		MyScanner fr = new MyScanner();
		TaskACVC solver = new TaskACVC();
		solver.solve(fr, out);

	}
}

class TaskACVC {
public void solve(MyScanner fr, PrintWriter out) {
		int n = fr.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += fr.nextInt();
		
		int sum1 =0;
		for (int i = 0; i < n -1 ; i++){
			sum1 += fr.nextInt();
		}
		int first = sum - sum1;
		sum =0;
		for (int i = 0; i < n -2 ; i++){
			sum += fr.nextInt();
		}
		int second = sum1 - sum;
		out.println(first);
		out.println(second);
		out.close();
	}
}


class MyScanner {
	BufferedReader br;
	StringTokenizer st;

	public MyScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public MyScanner(String file) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(file));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}
	
	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

}
