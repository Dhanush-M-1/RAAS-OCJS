import java.io.*;
import java.util.*;

public class Konoha {
    public static long check(long a, long b, int n)
    {
        long[] f = new long[3];
        
        if(n==0)
            return a;
            
        if(n==1)
            return b;
        
        if(n==2)    
            return (long)a^b;
        f[0]=a;
        f[1]=b;
        f[2]=a^b;
        return f[n%3];    
    }
    public static void main(String[] args) throws Exception {
	//try{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = System.out;
    	PrintWriter out = new PrintWriter(outputStream);

        int i, m, k=0, j;

        int t= Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a=Long.parseLong(st.nextToken());
            long b=Long.parseLong(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            
            
            out.println(check(a,b,n));
        }
	out.flush();
	out.close();
	//}catch(Exception e){}
	}
}