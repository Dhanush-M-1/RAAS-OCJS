import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	
    void solve() throws Exception {
    	String a = sc.nextToken();
    	String b = sc.nextToken();
    	String c = sc.nextToken();
    	int[] ca = new int[26];
    	int[] cb = new int[26];
    	int[] cc = new int[26];
    	int n = a.length();
    	int m = b.length();
    	int k = c.length();
    	for (int i = 0; i < n; i++) {
    		ca[a.charAt(i) - 'a']++;
    	}
    	for (int i = 0; i < m; i++) {
    		cb[b.charAt(i) - 'a']++;
    	}
    	for (int i = 0; i < k; i++) {
    		cc[c.charAt(i) - 'a']++;
    	}
    	int mx = 0;
    	int cnt = 0;
    	for (int i = 0; i < (n / m) + 1; i++) {
    		boolean ok = true;
    		int mn = Integer.MAX_VALUE;
    		for (int j = 0; j < 26; j++) {
    			if (ca[j] < cb[j] * i) {
    				ok = false;
    				break;
    			}
    			if (cc[j] > 0) {
    				mn = min(mn, (ca[j] - cb[j] * i) / cc[j]);
    			}
    		}
    		if (!ok) {
    			break;
    		}
    		if (mx < i + mn) {
    			mx = i + mn;
    			cnt = i;
    		}
    	}
    	for (int i = 0; i < cnt; i++) {
    		out.print(b);
    	}
    	int mn = Integer.MAX_VALUE;
    	for (int i = 0; i < 26; i++) {
    		ca[i] -= cb[i] * cnt;
    		if (cc[i] > 0)
    			mn = min(mn, ca[i] / cc[i]);
    	}
    	for (int i = 0; i < mn; i++) {
    		out.print(c);
    	}
    	for (int i = 0; i < 26; i++) {
    		ca[i] -= cc[i] * mn;
    	}
    	for (int i = 0; i < 26; i++) {
    		for (int j = 0; j < ca[i]; j++) {
    			out.print((char)('a' + i));
    		}
    	}
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