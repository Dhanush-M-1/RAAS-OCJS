import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class c303 {
	
	static class TaskA
    {
        public void solve(int testNumber, InputReader in, PrintWriter out) 
        {
        	int n=in.nextInt();
        	int arr[]=new int[n];
        	int dp[]=new int[n+1];
        	dp[0]=Integer.MAX_VALUE;
        	dp[n]=Integer.MAX_VALUE;
        	int temp[]=new int[n];
        	for(int i=0;i<n;i++)
        	{
        		temp[i]=in.nextInt();
        		arr[i]=in.nextInt();
        	}
        	for(int i=1;i<n;i++)
        	{
        		dp[i]=temp[i]-temp[i-1];
        	}
        	int count=0;
        	for(int i=0;i<n;i++)
        	{
        		if(arr[i]<dp[i])
        		{
        			count++;
        		}
        		else if(arr[i]<dp[i+1])
        		{
        			count++;
        			dp[i+1]-=arr[i];
        		}
        	}
        	out.println(count);
        }
    }
       
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
         
    static long min(long x,long y){return x<y?x:y;}
    static long min(long x,long y,long z){return x<y?(x<z?x:z):(y<z?y:z);}
    static long max(long x,long y){return x>y?x:y;}
    static long max(long x,long y,long z){return x>y?(x>z?x:z):(y>z?y:z);}
    static int min(int x,int y){return x<y?x:y;}
    static int min(int x,int y,int z){return x<y?(x<z?x:z):(y<z?y:z);}
    static int max(int x,int y){return x>y?x:y;}
    static int max(int x,int y,int z){return x>y?(x>z?x:z):(y>z?y:z);}
    
    static int abs(int x){if(x>=0)return x;else return -x;}
    static long abs(long x){if(x>=0)return x;else return -x;}
    
    
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
        
        public String nextLine() {
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
        	return Long.parseLong(next());
        }
        
        public double nextDouble() {
        	return Double.parseDouble(next());
        }

    }
}