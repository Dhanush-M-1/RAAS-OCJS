
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



	
	
public class Solution  {
	
	static class FastScanner{
		BufferedReader s;
		StringTokenizer st;
		
		
		public FastScanner(){
			st = new StringTokenizer("");
			s = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public FastScanner(File f) throws FileNotFoundException{
			st = new StringTokenizer("");
			s = new BufferedReader (new FileReader(f));
		}
		
		public int nextInt() throws IOException{
			if(st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else{
				st = new StringTokenizer(s.readLine());
				return nextInt();
			}
		}
		
		public double nextDouble() throws IOException{
			if(st.hasMoreTokens())
				return Double.parseDouble(st.nextToken());
			else{
				st = new StringTokenizer(s.readLine());
				return nextDouble();
			}
		}
		
		public long nextLong() throws IOException{
			if(st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else{
				st = new StringTokenizer(s.readLine());
				return nextLong();
			}
		}
		
		public String nextString() throws IOException{
			if(st.hasMoreTokens())
				return st.nextToken();
			else{
				st = new StringTokenizer(s.readLine());
				return nextString();
			}
			
		}
		public String readLine() throws IOException{
			return s.readLine();
		}
		
		public void close() throws IOException{
			s.close();
		}
		
	}
	
	
	
	
	//FastScanner s = new FastScanner(new File("input.txt"));       copy inside void solve
    //PrintWriter ww = new PrintWriter(new FileWriter("output.txt"));
    static FastScanner s = new FastScanner();   
    static PrintWriter ww = new PrintWriter(new OutputStreamWriter(System.out));
	
    public static void main(String args[])throws IOException{
    	//Main ob=new Main();
    	Solution ob=new Solution();
		ob.solve();
			ww.close();
    }
    ///////////////////////////////////
    
    	

    //////////////////////////////
	void solve() throws IOException{  
    	int n=s.nextInt();
    	
    	
    	long sum1=0;
    	long sum2=0;
    	
    	for(int i=0;i<n;i++)
    		sum1+=s.nextLong();
    	
    	for(int i=0;i<n-1;i++)
    		sum2+=s.nextLong();
    	
    	long n1=sum1-sum2;
    	long sum3=0;
    	for(int i=0;i<n-2;i++)
    		sum3+=s.nextLong();
    	
    	long n2=sum2-sum3;
    	
    	ww.println(n1);
    	ww.println(n2);
    	
    } //solve
    
    
}