import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
	
	private static StringTokenizer tokenizer;
    private static BufferedReader bf;
    private static PrintWriter out;
    private static int p = 1000;
    private static boolean[] e = new boolean[p];
    private static boolean[][] s = new boolean[1001][1001];
    
	private static int nextInt() throws IOException {
    	return Integer.parseInt(nextToken());
    }
    
	private static long nextLong() throws IOException {
    	return Long.parseLong(nextToken());
    }
    
    private static String nextToken() throws IOException {
    	while(tokenizer == null || !tokenizer.hasMoreTokens()) {
    		tokenizer = new StringTokenizer(bf.readLine());
    	}
    	return tokenizer.nextToken();
    }
    
    private static void isOk(int[] a, int n, int sum) {
    	for(int i = 0; i < n; i++)
    		s[0][i] = true;
    	for(int i = 1; i <= sum; i++)
    		s[i][0] = false;
    	for (int i = 1; i <= sum; i++) {
    		for (int j = 1; j <= n; j++) {
    			s[i][j] = s[i][j-1];
    			if (i >= a[j-1])
    				s[i][j] = s[i][j] || s[i-a[j-1]][j-1];
    		}
    	}
    	for(int i = 0; i <= sum; i++) {
    		for(int j = 0; j <= n; j++) {
    			if(s[i][j]) {
    				e[i] = true; break;
    			}
    		}
    	}
    }
    
	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
    	tokenizer = null;
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	int n = nextInt(); int x = nextInt();
    	int[] a = new int[n+1];
    	int[] b = new int[n+1];
    	boolean[] xe = new boolean[n+1]; int rank = 1;
    	int[] sum = new int[n]; int ind = x;
    	for(int i = 1; i <= n; i++) {
    		a[i] = nextInt();
    		if(a[i] != 0) b[a[i]] = i;
    	}
    	xe[x] = true;
    	while(a[ind] != 0) {
    		xe[a[ind]] = true; 
    		ind = a[ind]; rank++;
    	}
    	ind = x;
    	while(b[ind] != 0) {
    		xe[b[ind]] = true; ind = b[ind];
    	}
    	ind = 0;
    	for(int i = 1; i <= n; i++) {
    		if(!xe[i]) {
    			xe[i] = true;
    			int t = i; sum[ind] = 1;
    			while(a[t] != 0) {
    				sum[ind]++; xe[a[t]] = true; t = a[t];
    			}
    			t = i;
    			while(b[t] != 0) {
    	    		sum[ind]++; xe[b[t]] = true; t = b[t];
    	    	}
    			ind++;
    		}
    	}
    	isOk(sum, ind, n);
    	out.println(rank);
    	for(int i = 1; i < n; i++) {
    		if(e[i]) out.println(rank+i);
    	}
    	out.close();
	}

}
