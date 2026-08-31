import java.io.*;

public class A2 {

	public A2 () throws IOException {
		int N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		solve(N, X, Y);
	}
	
	public void solve (int N, int X, int Y) {
		start();
		int C = 0;
		for (C = 0; ; ++C)
			if (100 * (X+C) >= N * Y)
				exit (C);
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	static MyScanner sc;
	static long t;
	
	static void print (Object o) {
		System.out.println(o);
	}
	
	static void exit (Object o) {
		print(o);
		//print2((millis() - t) / 1000.0);
		System.exit(0);
	}
	
	static void run () throws IOException {
		sc = new MyScanner ();
		new A2();
	}
	
	public static void main(String[] args) throws IOException {
		run();
	}
	
	static long millis() {
		return System.currentTimeMillis();
	}
	
	static void start() {
		t = millis();
	}
	
	static class MyScanner {
		String next() throws IOException {
			newLine();
			return line[index++];
		}
		
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		String nextLine() throws IOException {
			line = null;
			return r.readLine();
		}

		//////////////////////////////////////////////
		
		private final BufferedReader r;

		MyScanner () throws IOException {
			this(new BufferedReader(new InputStreamReader(System.in)));
		}
		
		MyScanner(BufferedReader r) throws IOException { 
			this.r = r;
			newLine();
		}
		
		private String [] line;
		private int index;

		private void newLine() throws IOException {
			if (line == null || index == line.length) {
				line = r.readLine().split(" ");
				index = 0;
			}
		}		
	}	
}
