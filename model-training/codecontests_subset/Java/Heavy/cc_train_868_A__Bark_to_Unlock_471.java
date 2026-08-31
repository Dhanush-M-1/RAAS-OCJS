import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int test_cases = 1;
        Solver s = new Solver();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= test_cases; i++) {
            s.solve(i, in, out);
        }
        out.close();
    }
}

class Solver {
    void solve(int test_number, InputReader in, PrintWriter out) throws IOException {
        String p = in.next();
        int n = in.nextInt();
        boolean ok = false;
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
            if (p.charAt(0) == a[i].charAt(0) && p.charAt(1) == a[i].charAt(1) || p.charAt(1) == a[i].charAt(0) && p.charAt(0) == a[i].charAt(1)){
                ok = true;
                break;
            }
        }
        if (!ok) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (a[i].charAt(0) == p.charAt(1) && a[j].charAt(1) == p.charAt(0) || a[i].charAt(1) == p.charAt(0) && a[j].charAt(0) == p.charAt(1)) {
                        ok = true;
                        break;
                    }
                }
            }
        }
        out.println(ok ? "YES" : "NO");
    }
}


class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
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

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}