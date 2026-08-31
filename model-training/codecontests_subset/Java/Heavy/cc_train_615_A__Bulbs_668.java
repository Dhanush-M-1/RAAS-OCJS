import java.io.*;
import java.util.*;

public class j4 {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new j4().run();
    }

    public void solve() throws IOException 
    {
        int n = nextInt();
        int m = nextInt();
        int[]a = new int[100];
        for (int i = 0; i < m; i++)
            a[i] = 0;
        for (int i = 0; i < n; i++)
        {
            int k = nextInt();
            for (int j = 0; j < k; j++)
            {
                int q = nextInt();
                a[q - 1] = 1;
            }
        }
        for (int i = 0; i < m; i++)
        {
            if (a[i] == 0)
            {
                out.println("NO");
                return;
            }               
        }
        out.println("YES");
            
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}