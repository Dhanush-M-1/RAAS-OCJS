
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int ans = 0;
        for (int i = 0; i + 1 < n; i++)
        {
            if (a[i] - a[i + 1] > 0)
                ans = Math.max(ans, a[i] - a[i + 1] - c);
        }
        System.out.println(ans);
    }
}

class InputA
{
    BufferedReader bf;
    StringTokenizer st;

    public InputA() throws IOException
    {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
    }

    public String next() throws IOException
    {
        while (!st.hasMoreTokens() && bf.ready())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.hasMoreTokens() ? st.nextToken() : null;
    }

    public boolean hasNext() throws IOException
    {
        while (!st.hasMoreTokens() && bf.ready())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.hasMoreTokens();
    }

    public int nextInt() throws IOException
    {
        while (!st.hasMoreTokens() && bf.ready())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.hasMoreTokens() ? new Integer(st.nextToken()) : 0;

    }
}
