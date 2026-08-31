import java.io.*;
import java.util.*;

public class C
{
    public static void main(String[] strings) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int tc = Integer.parseInt(reader.readLine());

        while(tc-- > 0)
        {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long a = Long.parseLong(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());

            writer.println(rec(a, b) == 0 ? "Second" : "First");
            writer.flush();
        }

        writer.flush();
        writer.close();
    }

    private static int rec(long a, long b)
    {
        if (b < a)
        {
            return rec(b, a);
        }

        if(a == 0)
            return 0;

        long nb = b%a;
        long diff = b - nb;
        diff /= a;
        boolean can = (diff%(a+1))%2 == 0;

        if(can)
            return 1;

        return 1-rec(a, b%a);
    }
}