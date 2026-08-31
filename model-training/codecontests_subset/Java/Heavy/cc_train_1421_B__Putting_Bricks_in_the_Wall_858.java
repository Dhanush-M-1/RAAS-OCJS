import java.io.*;
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
import java.math.*;
public class Main 
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader()
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next()
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine();
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
     public static void main (String[] args) throws java.lang.Exception {
        FastReader sc=new FastReader();
        PrintWriter pw=new PrintWriter(System.out);
        int t=sc.nextInt();
        while(t-->0)
        {
           int n=sc.nextInt(),f=0;
           char c[][]=new char[n][n];
           for(int i=0;i<n;i++) 
           {
               String st=sc.nextLine();
               for(int j=0;j<n;j++)
               c[i][j]=st.charAt(j);
           }
           String s1=""+c[0][1]+c[1][0],s2=""+c[n-2][n-1]+c[n-1][n-2];
           if((s1.equals("00") && s2.equals("11")) ||(s1.equals("11") &&s2.equals("00"))) pw.println(0);
           else if((s1.equals("00") && s2.equals("00")) ||(s1.equals("11") &&s2.equals("11")))
           pw.println(2+"\n"+(1+" "+2)+"\n"+("2"+" "+"1"));
           else if((s1.equals("01") && s2.equals("10")) ||(s1.equals("10") &&s2.equals("01")))
           pw.println(2+"\n"+(1+" "+2)+"\n"+((n-1)+" "+(n)));
           else if((s1.equals("01") && s2.equals("01")) ||(s1.equals("10") &&s2.equals("10")))pw.println(2+"\n"+(1+" "+2)+"\n"+((n)+" "+(n-1)));
           else if(s1.equals("01"))
           {
           if(s2.equals("11"))
           pw.println(1+"\n"+(2+" "+1));
           else pw.println(1+"\n"+(1+" "+2));
           }
           else if(s1.equals("10"))
           {
           if(s2.equals("11"))
           pw.println(1+"\n"+(1+" "+2));
           else pw.println(1+"\n"+(2+" "+1));
           }
           else if(s2.equals("01"))
           {
           if(s1.equals("11"))
           pw.println(1+"\n"+(n+" "+(n-1)));
           else pw.println(1+"\n"+((n-1)+" "+n));
           }
           else if(s2.equals("10"))
           {
           if(s1.equals("11"))
           pw.println(1+"\n"+((n-1)+" "+n));
           else pw.println(1+"\n"+(n+" "+(n-1)));
           }
           
        }
    pw.close();
    }
}
  