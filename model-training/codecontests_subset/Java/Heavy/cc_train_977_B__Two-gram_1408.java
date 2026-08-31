import java.io.BufferedReader;
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
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int t = 1;//sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            char[] ar = s.toCharArray();
            
            HashMap<String,Integer> hm = new HashMap<>();
            
            for(int i=0;i<n-1;i++)
            {
                String key = ar[i]+""+ar[i+1];
                
                if(hm.containsKey(key))
                    hm.put(key,hm.get(key)+1);
                else
                    hm.put(key,1);
                    
            }
            int max = 0;
            String ans = "";
            
            for(Map.Entry<String,Integer> k : hm.entrySet())
            {
               if(k.getValue()>max)
               {
                    max = k.getValue();
                    ans = k.getKey();
               }
            }
        pw.println(ans);
        }
        pw.close();
    }
}