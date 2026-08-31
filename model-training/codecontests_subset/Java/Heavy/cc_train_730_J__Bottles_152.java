import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class Main {
    static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));  
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));  
      
    public static int nextInt()throws IOException {in.nextToken();return (int)in.nval;}  
    public static long nextLong()throws IOException {in.nextToken(); return (long)in.nval;}
    public static String next()throws IOException {in.nextToken();return (String)in.sval;}  

    static  int[] a = new int[120], b = new int[120];

    
    public static void main(String[] args) throws IOException {
    	int n = nextInt();
    	int sum = 0;
    	for (int i = 1; i <= n; i++) {
    		a[i] = nextInt();
    		sum += a[i];
    	}
    	for (int i = 1; i <= n; i++)
    		b[i] = nextInt();
    	qsort(1, n);
    	int k = 0;
    	for (int i = 1; i <= n; i++) {
    		k += b[i];
    		if (k >= sum) {
    			k = i;
    			break;
    		}
    	}
    	int[][] f = new int[105][100100];
    	for (int i = 0; i < 105; i++)
    		Arrays.fill(f[i], -1);
    	f[0][0] = 0;
    	for (int i = 1; i <= n; i++)
    		for (int j = sum - a[i]; j >= 0; j--)
    			for (int pre = i - 1; pre >= 0; pre--)
    				if (f[pre][j] != -1) 
    					f[pre + 1][j + a[i]] = Math.max(f[pre + 1][j + a[i]], f[pre][j] + b[i]);
    	int t = 0;
    	for (int i = sum; i >= 0; i--)
    		if (f[k][i] >= sum) {
    			t = i;
    			break;
    		}
    	out.println(k + " " + (sum - t));
    	out.flush();
    	out.close();
    }
    public static void qsort(int head, int tail) {
    	int x = b[(head + tail) / 2];
    	int i = head, j = tail;
    	while(i < j) {
    		while (b[i] > x) i++;
    		while (b[j] < x) j--;
    		if (i <= j) {
    			int k = b[i];
    			b[i] = b[j];
    			b[j] = k;
    			k = a[i];
    			a[i] = a[j];
    			a[j] = k;
    			i++;
    			j--;
    		}
    	}
    	if (head < j) qsort(head, j);
    	if (i < tail) qsort(i, tail);
    }
}

  	    		 	 						  		 	 			