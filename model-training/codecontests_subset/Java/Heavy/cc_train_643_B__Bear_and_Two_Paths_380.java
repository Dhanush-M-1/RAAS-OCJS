
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class TestClass {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[] ) throws Exception {
    	
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s[] = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        if(n==4 || k<=n)
        {
        	out.println(-1);
        	out.close();
        	System.exit(0);
        }
        String s1[] = in.readLine().split(" ");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1]);
        int c = Integer.parseInt(s1[2]);
        int d = Integer.parseInt(s1[3]);
        out.print(a+" "+c+" ");
        for(int i=1;i<=n;i++)
        {
        	if(i!=a && i!=b && i!=c && i!=d)
        	{
        		out.print(i+" ");
        	}
        }
        out.println(d+" "+b);
        
        out.print(c+" "+a+" ");
        for(int i=1;i<=n;i++)
        {
        	if(i!=a && i!=b && i!=c && i!=d)
        	{
        		out.print(i+" ");
        	}
        }
        out.println(b+" "+d);
        out.close();
    }
   
   
}


