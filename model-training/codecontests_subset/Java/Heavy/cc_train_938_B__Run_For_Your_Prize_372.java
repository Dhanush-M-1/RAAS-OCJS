import java.io.*;
import java.util.*;

public class Solving1 {

    
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int max1=1;
        int max2=1000000;
        for (int i = 0; i < n; i++) {
          int x=sc.nextInt();
          if(x<=500000){
            if(x>max1)max1=x;  
          }else{
             if(x<max2)max2=x; 
          }  
        }
        if(max1-1>1000000-max2)System.out.println(max1-1);
        else{
             int y=1000000-max2;
            System.out.println(y);
        }
        }
  //__________________________________________________________
    static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
            public FastScanner(InputStream i) {
	        br =  new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
	    public String next() throws IOException {
	        if(st.hasMoreTokens())return st.nextToken();
                else st = new StringTokenizer(br.readLine());
	        return next();
	    }
	    public int nextInt() throws IOException {return Integer.parseInt(next());}
	    public long nextLong() throws IOException {return Long.parseLong(next());}
	    public double nextDouble() throws IOException {return Double.parseDouble(next());}
	}
}