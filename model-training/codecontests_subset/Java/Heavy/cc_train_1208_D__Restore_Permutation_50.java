

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, sc, out);
        out.close();
    }

    static class Task {
    	public long[] C;
    	
    	public int lowBit(int x) {
    		return x&(-x);
    	}
    	
    	public void add(int x,int y) {
    		for(int i=x;i<C.length;i+=lowBit(i))
    			C[i]+=y;
    	}
    	
    	public long ask(int x) {
    		long res=0;
    		
    		for(int i=x;i>0;i-=lowBit(i))
    			res+=C[i];
    		
    		return res;
    	}
    	
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
        	int n=sc.nextInt();
        	C=new long[n+1];
            long[] s=new long[n+1];
            long[] res=new long[n+1];
            boolean[] jud=new boolean[n+1];
            
            for(int i=1;i<=n;i++) {
            	s[i]=sc.nextLong();
            	add(i,i);
            }
            for(int i=n;i>=1;i--) {
            	int l=1;
            	int r=n;
            	int ans=0;
            	while(l<=r) {
            		int mid=(l+r)>>1;
            	    long sum=ask(mid-1);
            	    if(s[i]==sum) {
            	    	if(jud[mid]) {
            	    		l=mid+1;
            	    		continue;
            	    	}
            	    	ans=mid;
            	    	jud[ans]=true;
            	    	add(mid,-mid);
            	    	break;
            	    }
            	    if(s[i]<sum)
            	    	r=mid-1;
            	    else
            	    	l=mid+1;
            	}
            	res[i]=ans;
            }
            for(int i=1;i<=n;i++)
            	out.print(res[i]+" ");
            out.println();
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
