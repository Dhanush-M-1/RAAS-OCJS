import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
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
    }

    public static void main(String[] args) {
        setup();
        xuly();
    }

    private static int n;
    private static String y, s[] = new String[100];

    private static void setup()
    {
        FastReader fastReader = new FastReader();
        y = fastReader.next();
        n = fastReader.nextInt();
        for(int i = 0; i < n; i ++)
            s[i] = fastReader.next();
        for(int i = 0; i < n; i ++)
        {
            if (s[i].equals(y))
            {
                System.out.print("YES");
                return;
            }
            for (int j = 0; j < n; j ++)
                if (s[i].charAt(1) == y.charAt(0) && s[j].charAt(0) == y.charAt(1))
                {
                    System.out.print("YES");
                    return;
                }
        }
        System.out.print("NO");
    }

    private static void xuly()
    {
    }
}
