import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class B {

	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void solve() throws IOException {
		char[] s = readString().toCharArray();
		TreeMap<String, Integer> count = new TreeMap<String, Integer>();
		
		int n = s.length;
		for(int i = 0; i < n - 9; i++){
			String c = new String();
			for(int j = 0; j < 10; j++){
				c += s[i+j];
			}
			if(check(c.toCharArray())){
				if(count.containsKey(c)){
					int cur = count.get(c);
					count.remove(c);
					count.put(c, cur+1);
				}
				else{
					count.put(c, 1);
				}
			}
		}
		
		String max = "";
		int mx = 0;
		for(String x: count.keySet()){
			int cur = count.get(x);
			if(cur > mx){
				mx = cur;
				max = x;
			}
		}
		out.println(max);
	}
	
	boolean check(char[] c){
		for(int i = 0; i < c.length; i++){
			if(!Character.isDigit(c[i]) && i != 2 && i != 5)
				return false;
			if(c[i] != '-' && (i == 2 || i == 5)) return false;
		}
		int day = 10 * (c[0]-'0') + (c[1]-'0');
		int month = 10*(c[3]-'0') + (c[4]-'0');
		int year = 1000*(c[6]-'0') + 100*(c[7]-'0') + 10*(c[8]-'0') + (c[9]-'0');
		if(year < 2013 || year > 2015) return false;
		if(month < 1 || month > 12) return false;
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(day < 1 || day > m[month-1]) return false;
		return true;
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
		new B().run();
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