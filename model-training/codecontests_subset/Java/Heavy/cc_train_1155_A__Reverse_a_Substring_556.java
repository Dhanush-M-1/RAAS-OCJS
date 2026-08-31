    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.HashMap;
    import java.util.TreeMap;
    import java.util.Map;
    import java.util.Arrays;
    import java.util.Set;
    import java.util.HashSet;
    import java.util.Iterator;
    import java.util.Collections;
    import java.util. LinkedList;
    
    /*
     *
     *  @author Riddle
     *
     */

    public final class ReverseASubstring
    {
        final static long MOD = (long)1e9+7;
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

        public static void main(String args[])
        {
            FastReader reader = new FastReader();
            PrintWriter out = new PrintWriter(System.out);
            int n = reader.nextInt();
            char ch[] = reader.next().toCharArray();
            int index = -1;
            for(int i=0;i<n-1;i++)
            {
                if(ch[i]>ch[i+1])
                {
                    index = i+1;
                    break;
                }
            }
            if(index==-1)
            {
                out.println("NO");
            }
            else
            {
                out.println("YES");
                out.println(index+" "+(index+1));
            }
            out.flush();        
            out.close();
        }
    }