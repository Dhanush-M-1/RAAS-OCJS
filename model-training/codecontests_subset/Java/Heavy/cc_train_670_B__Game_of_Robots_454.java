
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Main
{

    public static boolean check(String s)
    {
        StringBuilder newS = new StringBuilder(s);
        String revs = newS.reverse().toString();
        if (s.equals(revs)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException
    {
        FastScanner input = new FastScanner();
       int n = input.nextInt();
       long k = input.nextLong()-1;
       int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            
        }
        long sum=0;
        int i=1;
        while((sum+i)<=k)
        {
            sum+=i;
            i++;
        }
        System.out.println(a[(int)(k-sum)%n]);
    }

    static class FastScanner
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next()
        {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

        String nextLine() throws IOException
        {
            return br.readLine();
        }
    }

}
