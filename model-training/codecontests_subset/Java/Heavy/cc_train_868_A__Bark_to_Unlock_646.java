import java.util.*;
import java.io.*;

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

	public static void main (String[] args)
	{
		FastReader reader = new FastReader();
	    String password = reader.nextLine();

        boolean check = false;
        int i, j, totalHits = reader.nextInt();
        String[] allTrys = new String[totalHits];

        for (i=0; i<totalHits; i++)
        { 
            allTrys[i] = reader.nextLine();

            if (password.equals(allTrys[i]))
                check = true;
        }

        boolean test1=false, test2=false;

        for (i=0; i<totalHits; i++)
        {
            if (allTrys[i].charAt(0) == password.charAt(1))
                test1 = true;
        
            if (allTrys[i].charAt(1) == password.charAt(0))
                test2 = true;
        }

        if (test2 && test1)
            check = true;

        if (check)
            System.out.println ("YES");
        else
            System.out.println ("NO");
    }	
}