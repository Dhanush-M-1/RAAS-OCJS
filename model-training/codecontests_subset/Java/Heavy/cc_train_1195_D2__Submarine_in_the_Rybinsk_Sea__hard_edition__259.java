

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
    	public static final long mod=998244353;
    	
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int n=sc.nextInt();
            int[] cnt=new int[20];
            long[] a=new long[n+1];
            
            for(int i=1;i<=n;i++) {
            	a[i]=sc.nextLong();
            	cnt[Long.toString(a[i]).length()]++;
            }
            long ans=0;
            for(int i=1;i<=n;i++) {
            	String res=Long.toString(a[i]);
            	for(int j=1;j<=19;j++) {
            		if(cnt[j]==0)
            			continue;
            		long x=0;           //后
            		long y=0;           //前
            		for(int k=0;k<res.length();k++) {
            			if(j>=res.length()) {
            				x=x*100+res.charAt(k)-'0';
            				x%=mod;
            				y=y*100+(res.charAt(k)-'0')*10;
            				y%=mod;
            			}
            			if(j<res.length()) {
            				if((res.length()-k)<=j) {
            					x=x*100+res.charAt(k)-'0';
                				x%=mod;
                				y=y*100+(res.charAt(k)-'0')*10;
                				y%=mod;
            				}
            				else {
            					x=x*10+res.charAt(k)-'0';
                				x%=mod;
                				y=y*10+res.charAt(k)-'0';
                				y%=mod;
            				}
            			}
            		}
            		
            		x*=cnt[j];
        			x%=mod;
        			y*=cnt[j];
        			y%=mod;
        			ans=((x+y)%mod+ans)%mod;
            	}
            }
            out.println((ans+mod)%mod);
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
