import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

public class A{
static class Node implements Comparable<Node>{
	int id;
	long d;
	public Node(int id,long d) {
		this.id=id;
		this.d=d;
	}
	public int compareTo(Node c) {
		return Long.compare(this.d, c.d);
	}
}
//public static PrintWriter pw; 	
public static PrintWriter pw=new PrintWriter(System.out);
public static void solve() throws IOException{
//	pw=new PrintWriter(new FileWriter("C:\\Users\\shree\\Downloads\\small_output_in"));
	FastReader sc=new FastReader();
	int n=sc.I();
	int m=sc.I();
	long p=sc.L();
	long a[]=new long [n+1];
	long b[]=new long[m+1];
	for(int i=1;i<=n;i++)a[i]=sc.L();
	for(int i=1;i<=m;i++)b[i]=sc.L();
	Arrays.sort(a);
	Arrays.sort(b);
	long dp[][]=new long[n+1][m+1];
	for(int i=0;i<=n;i++)Arrays.fill(dp[i],(long) 1e18);
	for(int i=0;i<=m;i++)dp[0][i]=0;
	for(int i=1;i<=n;i++) {
		for(int j=1;j<=m;j++) {
			dp[i][j]=Math.min(dp[i][j-1], Math.max(dp[i-1][j-1],Math.abs(a[i]-b[j])+Math.abs(b[j]-p)));
		}
	}
	pw.println(dp[n][m]);
	pw.close(); 
	
	
}

public static void main(String[] args)  {
    new Thread(null ,new Runnable(){
      public void run(){
          try{
          
              solve();
          } catch(Exception e){
              e.printStackTrace();
          }
      }
  },"1",1<<26).start();
 
}

static long M=(long)Math.pow(10,9)+7;
 
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() throws FileNotFoundException{
            //br=new BufferedReader(new FileReader("C:\\Users\\shree\\Downloads\\B-small-practice.in"));	
        	 br = new BufferedReader(new InputStreamReader(System.in));
        		
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
       
        int I(){   return Integer.parseInt(next()); }
        long L(){  return Long.parseLong(next()); }
        double D() {  return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
     }
}