import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem168A
{
    public static void main(String[] args) throws IOException
    {
        fastinput.init(System.in);
        int n = fastinput.nextInt();
        int x = fastinput.nextInt();
        double y = Double.valueOf(fastinput.nextInt())/100;
        int threshold = (int)Math.ceil(n*y);
        if (x >= threshold)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(threshold-x);
        }
    }
    
    public static class fastinput
    {
        static BufferedReader bf;
        static StringTokenizer st;
        
        static void init(InputStream input)
        {
            bf = new BufferedReader(new InputStreamReader(input));
            st = new StringTokenizer("");
        }
        
        static String nextline() throws IOException
        {
            return bf.readLine();
        }
        
        static String next() throws IOException
        {
            while (!st.hasMoreTokens())
            {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }
        
        static int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        
        static long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
    }
}
