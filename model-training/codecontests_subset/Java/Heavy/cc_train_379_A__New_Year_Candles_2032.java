import java.util.*;
import java.io.*;

public class Test{

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int count = 0;
        int result = 0;
        while(n>0){
            n-=1;
            count += 1;
            if(count == m)
            {
                n+= 1;
                count = 0;
            }
            result++;
        }
        System.out.println(result);


    }



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

}