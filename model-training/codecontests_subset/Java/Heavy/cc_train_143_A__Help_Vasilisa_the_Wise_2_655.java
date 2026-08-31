import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HelpVasilisaTheWise2 {
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
	    reader(System.in);
	    int r1 = nI();
	    int r2 = nI();
	    int c1 = nI();
	    int c2 = nI();
	    int d1 = nI();
	    int d2 = nI();
	    for (int i = 1; i < 10; i++) {
	    	for (int j = 1; j < 10; j++) {
	    		if (i != j)
	    		for (int k = 1; k < 10; k++) {
	    			if (i != k && j != k)
		    	    	for (int l = 1; l < 10; l++) {
		    	    		if (i != l && j != l && k != l)
			    	    		if (r1 == i + j && r2 == k + l && c1 == i + k && c2 == j + l && d1 == i + l && d2 == j + k) {
			    	    			System.out.println (i + " " + j);
			    	    			System.out.println (k + " " + l);
			    	    			return;
			    	    		}
		    		    }
	    	    }
		    }
	    }
	    pw.println(-1);
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