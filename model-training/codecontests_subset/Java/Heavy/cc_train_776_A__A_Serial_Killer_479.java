import java.util.*;
import java.io.*;

public class SerialKiller {
    
    public static void solve() {
    	String a = next();
    	String b = next();
    	
    	int n = nextInt();
    	
    	for (int i =0; i < n; i++) {
    		String died = next();
    		String next = next();
    		System.out.println(a + " " + b);
    		
    		if(a.equals(died)) {
    			a = next;
    		} else {
    			b = next;
    		}
    	}
    	
    	System.out.println(a + " " + b);
    
    }
    private static void run() {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);
    	
    	solve();
    	
    	out.close();
    }
    
    private static StringTokenizer st;
    private static BufferedReader br;
    private static PrintWriter out;
    
    private static String next() {
    	while (st == null || !st.hasMoreElements()) {
    		String s;
    		try {
    			s = br.readLine();
    		} catch (IOException e) {
    			return null;
    		}
    		st = new StringTokenizer(s);
    	}
    	return st.nextToken();
    }
    
    private static int nextInt() {
    	return Integer.parseInt(next());
    }
    
    private static long nextLong() {
    	return Long.parseLong(next());
    }
    
    public static void main(String[]args){
    	run();
    }
    
}