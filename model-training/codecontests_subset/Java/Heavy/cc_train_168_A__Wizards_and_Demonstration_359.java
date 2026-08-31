import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WizardsAndDemonstration {
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
	    reader(System.in);
	    int n = nI();
	    int x = nI();
	    int y = nI();
	    int res = (int) Math.ceil((n / 100.0) * y - x);
	    pw.println(res < 0 ? 0 : res);
	    pw.close();
	}
	
	private static BufferedReader br;
	private static StringTokenizer st;

	static void reader(InputStream stream) {
	    try {
	        br = new BufferedReader(new InputStreamReader(stream));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	static String n() {
	    while (st == null || !st.hasMoreTokens()) {
	        try {
	            st = new StringTokenizer(br.readLine());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return st.nextToken();
	}

	static int nI() {
	    return Integer.parseInt(n());
	}
	
	static long nL() {
	    return Long.parseLong(n());
	}
}