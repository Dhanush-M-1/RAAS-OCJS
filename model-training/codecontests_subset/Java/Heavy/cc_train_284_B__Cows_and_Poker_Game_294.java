import java.io.*;
import java.util.*;

public class C174B
{

private static StringTokenizer st;
    
    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }
    
    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }
    
    public static String next()
    {
        return st.nextToken();
    }
    
    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int n = nextInt();
        nextLine(br);
        String s = next();
        int allin = 0;
        int in = 0;
        int folded = 0;
        for (int i = 0; i < n; i++)
        {
            switch (s.charAt(i))
            {
            case 'A':
                allin++;
                break;
            case 'I':
                in++;
                break;
            case 'F':
                folded++;
                break;
            }
        }
        if (in == 0)
        {
            System.out.println(allin);
        }
        else if (in == 1)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }
    }
    

}