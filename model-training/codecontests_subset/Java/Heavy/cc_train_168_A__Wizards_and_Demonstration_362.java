import java.io.PrintWriter; 
import java.io.InputStreamReader;
import java.io.BufferedReader;  
import java.util.StringTokenizer; 
import java.util.TreeMap; 
import java.util.Map; 

public class a_mu implements Runnable {
	BufferedReader in; 
	PrintWriter out; 
	StringTokenizer st; 

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch (Exception e) {}
		}
		return st.nextToken(); 
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out= new PrintWriter(System.out);
				long n = nextLong(); 
				long x = nextLong(); 
				long y = nextLong(); 

				long k = (n*y+99)/100; 

				out.println(Math.max(k-x,0));
			out.close(); 
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new a_mu()).start();
	}
}