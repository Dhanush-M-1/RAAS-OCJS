import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class C500 implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	public static void main(String[] args) {
		new Thread(null, new C500(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			}
			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Throwable t) {
			t.printStackTrace(System.err);
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

	// solution
	
	void solve() throws IOException {
		int n = readInt(); int m = readInt();
		int[] w = new int[n];
		int[] o = new int[m];
		int[] p = new int[n];
		Arrays.fill(p, n);
		for(int i =0; i<n; i++){
			w[i] = readInt();
		}
		for(int i =0; i<m; i++){
			o[i] = readInt();
		}
		int count = 0;
		for(int i =0; i<m; i++){
			int c = p[o[i]-1];
			if(p[o[i]-1]==n){
				p[o[i]-1] = count;
				count++;
			}
		}
		ArrayList<Integer> st = new ArrayList<Integer>();
		for(int j =0; j<count; j++){
			for(int i =0; i<p.length; i++){
				if(p[i]==j){
					int a = i;
					st.add(i);
					break;
				}
			}
		}
		int s = 0;
		for(int i =0; i<m; i++){
			int tempS = 0;
			int index = 0;
			for(int j =0; j<st.size(); j++){
				if(st.get(j)==o[i]-1){
					index = j;
					break;
				}
			}
//			for(int j =0; j<st.size(); j++){
//				System.out.println(st.get(j));
//			}
			for(int j = 0; j<index; j++){
				tempS+=w[st.get(j)];
			}
			s+=tempS;
			int q = st.get(index);
			st.remove(index);
			st.add(0, q);
		}
		out.println(s);
		
	}
}
