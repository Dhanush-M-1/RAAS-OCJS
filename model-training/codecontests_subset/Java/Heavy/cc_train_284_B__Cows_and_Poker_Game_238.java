/*
    Aman Agarwal
    algo.java
*/

import java.util.*;
import java.io.*;

public class B284
{
    static class FastReader
    {
            BufferedReader br;
            StringTokenizer st;

            public FastReader()
            {
                br = new BufferedReader(new InputStreamReader(System.in));
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


    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) 
    {
        int t = 1;
        //t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int a = 0;
            int i = 0;
            int f = 0;
            for(int k=0;k<n;k++)
            {
                if(s.charAt(k)=='A')
                    a++;
                else if(s.charAt(k)=='F')
                    f++;
                else
                    i++;
            }
            if(i>1)
                out.println(0);
            else
            {
                if(i==0)
                    out.println(a);
                else
                    out.println(1);
            }
            out.flush();
        }    
    }
}
