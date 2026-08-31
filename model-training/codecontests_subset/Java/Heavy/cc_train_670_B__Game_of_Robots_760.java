

import java.io.*;
import java.util.*;
public class TestClass {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s[] = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String s1[] = in.readLine().split(" ");
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
        	a[i] = Integer.parseInt(s1[i]);
        }
        for(int i=1;;i++)
        {
        	if(k-i>0)
        	{
        		k = k-i;
        	}
        	else
        	{
        		out.println(a[k-1]);
        		break;        	
    		}
        }
        out.close();
    }
    
       

}
