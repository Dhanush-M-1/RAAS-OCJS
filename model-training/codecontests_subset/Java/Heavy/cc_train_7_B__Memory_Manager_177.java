import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BetaRound7_B implements Runnable {
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;
	
	@Override
	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter("output.txt");
			}
			tok = new StringTokenizer("");
			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			long endTime = System.currentTimeMillis();
			long totalMemory = Runtime.getRuntime().totalMemory();
			long freeMemory = Runtime.getRuntime().freeMemory();
			System.err.println("Time = " + (endTime - startTime) + " ms");
			System.err.println("Memory = " + ((totalMemory - freeMemory) / 1024) + " KB");
		} catch (Throwable e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
	
	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
	
	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}
	
	long readLong() throws IOException {
		return Long.parseLong(readString());
	}
	
	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}
	
	public static void main(String[] args) {
		new Thread(null, new BetaRound7_B(), "", 256 * 1024 * 1024).start();
	}
	
//------------------------------------------------------------------------------
	
	void solve() throws IOException {
		int q = readInt();
		int n = readInt();
		int[] a = new int[n];
		boolean[] b = new boolean[111];
		while (q --> 0) {
			String type = readString();
			if (type.equals("alloc")) {
				int size = readInt();
				boolean ok = false;
				for (int i = 0; i + size - 1 < n; i++) {
					ok = true;
					for (int j = i; j < i + size; j++) {
						if (a[j] != 0) {
							ok = false;
							break;
						}
					}
					if (ok) {
						int id = 1;
						while(b[id]) id++;
						b[id] = true;
						for (int j = i; j < i + size; j++) {
							a[j] = id;
						}
						out.println(id);
						break;
					}
				}
				if (!ok) {
					out.println("NULL");
				}
			} else if (type.equals("erase")) {
				int id = readInt();
				boolean ok = false;
				if (id >= 0 && id < b.length && b[id]) {
					for (int i = 0; i < n; i++) {
						if (a[i] == id) {
							ok = true;
							while (i < n && a[i] == id) {
								a[i] = 0;
								i++;
							}
							break;
						}
					}
				}
				if (!ok) {
					out.println("ILLEGAL_ERASE_ARGUMENT");
				}
			} else if (type.equals("defragment")) {
				int[] x = new int[n];
				for (int i = 0, j = 0; i < n; i++) {
					if (a[i] != 0) {
						x[j++] = a[i];
					}
				}
				a = x;
			}
		}
	}
	
}
