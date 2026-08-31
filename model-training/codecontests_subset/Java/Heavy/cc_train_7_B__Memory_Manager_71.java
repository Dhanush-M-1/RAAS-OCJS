import java.io.*;
import java.util.*;
import java.math.*;


public class Solution
{
   

   PrintWriter out;
   BufferedReader in;
   StringTokenizer ss;


   void dbg(String s){System.out.println(s);};

   String _token() throws IOException
   {
    while (!ss.hasMoreTokens())ss=new StringTokenizer(in.readLine());
    return ss.nextToken();
   }

   Double _double() throws IOException
   {
    return Double.parseDouble (_token());
   }

   int _int() throws IOException
   {
    return Integer.parseInt (_token());
   }

   long _long() throws IOException
   {
    return Long.parseLong (_token());
   }

   
   void run()throws IOException
    {
     in = new BufferedReader(new InputStreamReader(System.in));
     out = new PrintWriter(System.out);
     ss = new StringTokenizer("  ");

     int t=_int();
     int m=_int();
     int n=1;
     int a[]= new int[m];
     for(int r=0;r<t;r++)
     {
       String s=_token();
       long q=-1;
       if (s.compareTo("alloc")==0)
       {
         q=_long();

         int j=0;
         boolean ok=false;
         for(int i=0;i<m && !ok;i++)
         {
           if (a[i]!=0)
             j=i+1;
           if (i-j+1>=q)
           {
             ok=true;
             out.println(n);
             for(int w=j;w<=i;w++)
               a[w]=n;
             n++;
           }
         }
         if (!ok)
           out.println("NULL");
       }

       if (s.compareTo("erase")==0)
       {
         boolean was=false;
         q=_long();
         for(int i=0;i<m;i++)
           if(a[i]==q && q!=0)
             {
               a[i]=0;
               was=true;
             }
         if (!was)
           out.println("ILLEGAL_ERASE_ARGUMENT");
       }
       if (s.compareTo("defragment")==0)
       {
         for(int i=0;i<m;i++)
         {
           int j=i-1;
           while (j>=0 && a[j]==0)
             j--;
           j++;
           a[j]=a[i];
           if (i!=j)
             a[i]=0;
         }
       }
     }
     out.close();
    }






public static void main(String[] args)throws Exception
{
new Solution().run();
}
}