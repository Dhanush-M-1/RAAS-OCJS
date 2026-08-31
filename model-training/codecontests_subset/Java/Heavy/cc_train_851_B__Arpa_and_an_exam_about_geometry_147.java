import java.io.*;
import java.util.*;

public class Problems2{
   static class pair{
       long x;
       long y;
       public pair(int x,int y){
           this.x=x;
           this.y=y;
       }
   }
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner(System.in);
        pair a=new pair(sc.nextInt(),sc.nextInt());
        pair b=new pair(sc.nextInt(),sc.nextInt());
        pair c=new pair(sc.nextInt(),sc.nextInt());
        
        if((b.y-a.y)*(b.x-c.x)==(b.y-c.y)*(b.x-a.x))System.out.println("No");
        else if(dis(a,b)==dis(b,c))System.out.println("Yes");
        else System.out.println("No");
            
        
        
    }
    public static long dis(pair a,pair b){
        return ((a.y-b.y)*(a.y-b.y))+((a.x-b.x)*(a.x-b.x));
    }
    public static double slop(pair a,pair b){
        return (a.y-b.y)/(a.x-b.x);
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
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    //#
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	    //$
	}
}