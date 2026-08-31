import java.io.*;
import java.util.StringTokenizer;

public class C {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

	void solve() throws IOException {
		int n = readInt();
		int m = readInt();
		int[] a = new int[n];
		int[] b = new int[m];
		for(int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		for(int i = 0; i < m; i++) {
			b[i] = readInt()-1;
		}
		long sum = 0;
		for(int i = 1; i < m; i++) {
			int cur = b[i];
			boolean[] used = new boolean[n];
			for(int j = i-1; j >= 0; j--) {
				if(b[j] == cur) {
					break;
				} else {
					if(used[b[j]]) continue;
					sum += a[b[j]];
					used[b[j]] = true;
				}
			}
		}
		out.println(sum);
	}


    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
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

    int[] readArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readArrL(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public static void main(String[] args) {
        new C().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}