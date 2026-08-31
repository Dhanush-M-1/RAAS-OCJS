import java.io.*;
import java.util.*;

public class codeforces {
	public static PrintWriter out;
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
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
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	// The next two void functions are shuffle functions on an array.
	// This way, quick sort encounters the worst case scenario with low probability.
	// A reason for doing this is if we don't a primitive data array to an object array.
	// For safety reasons, it would be preferable to use object arrays unless doing so expends a lot of time.
	public static void shuffleLongArray(long[] arr) {
		int n = arr.length;
		Random rnd = new Random();
        for (int i=0; i < n; i++) {
        	long tmp = arr[i];
        	int randomPos = i + rnd.nextInt(n-i);
        	arr[i] = arr[randomPos];
        	arr[randomPos] = tmp;
        }
	}
	public static void shuffleIntArray(int[] arr) {
		int n = arr.length;
		Random rnd = new Random();
        for (int i=0; i < n; i++) {
        	int tmp = arr[i];
        	int randomPos = i + rnd.nextInt(n-i);
        	arr[i] = arr[randomPos];
        	arr[randomPos] = tmp;
        }
	}
	public static void main (String[] args) throws IOException {
    	MyScanner sc = new MyScanner();
    	out = new PrintWriter(new BufferedOutputStream(System.out));
    	// Write your solution here.
    	int t = sc.nextInt();
    	for (int asap=0; asap < t; asap++) {
    		int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt(); int moves = 0;
    		while (b >= 1 && c >= 2) {
    			moves++;
    			c -= 2; b -= 1;
    		}
    		while (a >= 1 && b >= 2) {
    			moves++;
    			b -= 2; a -= 1;
    		}
    		out.println(3*moves);
    	}
    	out.close();
	}
	
}