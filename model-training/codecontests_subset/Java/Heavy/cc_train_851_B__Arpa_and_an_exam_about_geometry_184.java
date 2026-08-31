
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import javafx.util.Pair;

public class Main
{

     

    public static void main(String args[])
    {
        FastScanner input = new FastScanner();
       long ax = input.nextInt();
       long ay = input.nextInt();
       long bx = input.nextInt();
       long by = input.nextInt();
       long cx = input.nextInt();
       long cy = input.nextInt();
       long dis1 = ((ax-bx)*(ax-bx))+((ay-by)*(ay-by));
       long dis2 = ((bx-cx)*(bx-cx))+((by-cy)*(by-cy));
       boolean check= ((by-ay)*(cx-bx)==(cy-by)*(bx-ax));
       if(!check&&dis1==dis2)
       {
           System.out.println("YES");
       }
       else
            System.out.println("NO");
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
