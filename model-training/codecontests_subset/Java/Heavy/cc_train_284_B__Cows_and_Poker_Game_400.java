import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem284B
{
    public static void main(String[] args) throws IOException
    {
        fastinput.init(System.in);
        int n = fastinput.nextInt();
        String input = fastinput.next();
        int counta = 0;
        int counti = 0;
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == 'A')
            {
                counta++;
            }
            if (input.charAt(i) == 'I')
            {
                counti++;
            }
        }
        if (counti > 1)
        {
            System.out.println("0");
        }
        else if (counti == 1)
        {
            System.out.println("1");
        }
        else
        {
            System.out.println(counta);
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