import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


public class B {
	static PrintWriter out;
	static StreamTokenizer st;
	static BufferedReader bf;
	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StreamTokenizer(bf);
		out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = nextInt();
		nextLine();
		char []a = nextLine().toCharArray();
		int aa = 0;
		int ii = 0;
		int ff = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 'A') aa++;
			else
				if (a[i] == 'I') ii++;
				else ff++;
		}
		int ans = 0;
		if (ii == 0 ){
			ans = aa;
		}else{
			if (ii == 1) ans  = 1;
		}
		System.out.println(ans);
	}
	private static String nextLine() throws IOException {
		return bf.readLine().trim();
	}
	private static double nextDouble() throws IOException{
		st.nextToken();
		return st.nval;
	}
	private static long nextLong()  throws IOException{
		st.nextToken();
		return (long) st.nval;
	}
	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

}
