import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.lang.*;
import java.math.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	
	double getWeak(double[] a) {
		int n = a.length;
		double ans = 0.0;
		double sm = 0.0;
		double[] mn = new double[n + 1];
		double[] mx = new double[n + 1];
		for (int i = 0; i < n; i++) {
			sm += a[i];
			ans = max(ans, abs(sm - mn[i]));
			ans = max(ans, abs(sm - mx[i]));
			mn[i + 1] = min(mn[i], sm);
			mx[i + 1] = max(mx[i], sm);
		}
		return ans;
	}
	
    void solve() throws Exception {
    	int n = sc.nextInt();
    	double[] c = new double[n];
    	for (int i = 0; i < n; i++) {
    		c[i] = sc.nextInt();
    	}
    	double[] a = new double[n];
    	double[] b = new double[n];
    	double lf = -1e4, rg = 1e4;
    	for (int it = 0; it < 100; it++) {
    		double md1 = (2.0 * lf + rg) / 3.0;
    		double md2 = (lf + 2.0 * rg) / 3.0;
    		for (int i = 0; i < n; i++) {
    			a[i] = c[i] - md1;
    			b[i] = c[i] - md2;
    		}
    		if (getWeak(a) > getWeak(b)) {
    			lf = md1;
    		} else {
    			rg = md2;
    		}
    	}
    	for (int i = 0; i < n; i++) {
    		c[i] -= lf;
    	}
    	out.format("%.10f%n", getWeak(c));
    }
    
    BufferedReader in;
    PrintWriter out;
    FastScanner sc;
    
    final String INPUT_FILE = "stdin";
    final String OUTPUT_FILE = "stdout";
    
    static Throwable throwable;
    
    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        thread.run();
        if (throwable != null)
            throw throwable;
    }
    
    
    public void run() {
        try {
            if (INPUT_FILE.equals("stdin"))
                in = new BufferedReader(new InputStreamReader(System.in));
            else
                in = new BufferedReader(new FileReader(INPUT_FILE));
            if (OUTPUT_FILE.equals("stdout"))
                out = new PrintWriter(System.out);
            else
                out = new PrintWriter(new FileWriter(OUTPUT_FILE));
            sc = new FastScanner(in);
            solve();
        } catch (Exception e) {
            throwable = e;
        } finally {
            out.close();
        }
    }
}

class FastScanner {
    BufferedReader reader;
    StringTokenizer strTok;
    
    FastScanner(BufferedReader reader) {
        this.reader = reader;
    }
    
    public String nextToken() throws Exception {
        while (strTok == null || !strTok.hasMoreTokens())
            strTok = new StringTokenizer(reader.readLine());
        return strTok.nextToken();
    }
    
    public boolean EOF() throws Exception {
    	if (strTok != null && strTok.hasMoreTokens()) {
    		return false;
    	} else {
    		String line = reader.readLine();
    		if (line == null)
    			return true;
    		strTok = new StringTokenizer(line);
    		return false;
    	}
    }
    
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}