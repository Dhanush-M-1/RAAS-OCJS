import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
			}
		}

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw e;
				}
			}
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(nextToken());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(nextToken());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(nextToken());
		}
	}

	
	private int max(int a[]) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	Main() throws IOException {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int n = in.nextInt();
		long k = in.nextLong();
		
		long t=1;
		
		while (k>t) {
			k -= t++;
		}
		
		k--;
		
		while (k-- > 0) {
			in.nextInt();
		}

		out.print(in.nextInt());
		
		out.flush();
		out.close();

	}
	
	private int remMin(int n) {
		switch(n) {
		case 1:case 2: case 3: case 4: case 5:  return 0;
		case 6:case 7:return 2;
		}
		
		return 0;
	}


	private int remMax(int n) {
		if (n == 1) {
			return 1;
		} else if (n > 1) {
			return 2;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		new Main();
	}



}