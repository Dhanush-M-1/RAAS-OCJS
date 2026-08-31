import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1382
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int m = readInt();
            HashSet<Integer> first = new HashSet<>();
            for (int i = 0; i < n; i++)
            {
                first.add(readInt());
            }
            boolean found = false;
            for (int i = 0; i < m; i++)
            {
                int cur = readInt();
                if (!found)
                {
                    if (first.contains(cur))
                    {
                        System.out.println("YES 1 " + cur);
                        found = true;
                    }
                }
            }
            if (!found)
            { System.out.println("NO"); }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
