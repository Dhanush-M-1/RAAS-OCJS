
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class TestClass {
   
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String args[] ) throws Exception {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s[] = in.readLine().split(" ");
        int n = Integer.parseInt(in.readLine());
        String ans[][] = new String[n+1][2];
        ans[0][0] = s[0];
        ans[0][1] = s[1];
        out.println(s[0]+" "+s[1]);
        for(int i=1;i<=n;i++)
        {
        	String q[] = in.readLine().split(" ");
        	if(ans[i-1][0].equals(q[0]))
        	{
        		ans[i][0] = q[1];
        		ans[i][1] = ans[i-1][1];
        	}
        	else 
        	{
        		ans[i][1] = q[1];
        		ans[i][0] = ans[i-1][0];
        	}
        	out.println(ans[i][0]+" "+ans[i][1]);
        }
        out.close();
    }
   
}