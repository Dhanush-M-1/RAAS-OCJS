/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Balloons
{
    public static void main (String[] args) throws java.lang.Exception
    {
    try {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split("");
        int n=Integer.parseInt(br.readLine());
        String s1=s[0];
        String s2=s[1];
        boolean first=false,sec=false;
        while(n-->0)
        {
            String k[]=br.readLine().split("");
            String k1=k[0];
             String k2=k[1];
             if(s1.equals(k2) )
                sec=true;
             if(s2.equals(k1))  
                first=true;
                if(s1.equals(k1) && s2.equals(k2))
                    {
                        first=true;
                        sec=true;}
        }
        if(sec && first)
            System.out.println("YES");
        else
            System.out.println("NO");
       
    } catch(Exception e) {
    return;}
    }
    
}
