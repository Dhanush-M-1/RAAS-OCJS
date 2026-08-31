import java.io.*;
import java.util.*;
public class Mafia{
	public static void main(String[]args){
		MyScanner sc=new MyScanner();
        PrintWriter pw=new PrintWriter(System.out);
        int n=sc.nextInt();
        long[] a=new long[n+1];
        long sum=0;
        long max=0;
        for(int i=0;i<n;i++){a[i]=sc.nextLong();sum+=a[i];max=Math.max(max,a[i]);}
        long ans=(sum-1)/(n-1) + 1;
    	ans=Math.max(ans,max);
    	//System.out.println("sum-->"+sum);
    	//if(ans<max)ans=max;
    	pw.println(ans);
    	pw.flush();
    	pw.close();
	}
	static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {while (st == null || !st.hasMoreElements()) {
            try {st = new StringTokenizer(br.readLine());}
            catch (IOException e) {e.printStackTrace();}}
            return st.nextToken();}
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        String nextLine(){String str = "";
            try {str = br.readLine();}
            catch (IOException e) {e.printStackTrace();}
            return str;}
	}
}