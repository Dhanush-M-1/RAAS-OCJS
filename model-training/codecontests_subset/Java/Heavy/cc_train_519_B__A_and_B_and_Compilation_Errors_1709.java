import java.io.*;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/**
 * Created by simin on 3/5/15.
 */
public class B
{
    public static void main(String []args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int first = 0, second = 0;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++)
        {
            int tmp = Integer.parseInt(tokenizer.nextToken());
            first ^= tmp;
        }
        second = first;
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n - 1; i++)
        {
            int tmp = Integer.parseInt(tokenizer.nextToken());
            first ^= tmp;
        }
        second ^= first;
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n - 2; i++)
        {
            int tmp = Integer.parseInt(tokenizer.nextToken());
            second ^= tmp;
        }
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        writer.println(first);
        writer.println(second);
        writer.flush();
        writer.close();
    }
}
