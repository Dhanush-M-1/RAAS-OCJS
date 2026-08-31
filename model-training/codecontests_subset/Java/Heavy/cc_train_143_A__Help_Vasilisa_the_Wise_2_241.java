import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int test_cases = 1;
        Solver s = new Solver();
        for (int i = 1; i <= test_cases; i++) {
            s.solve(i, in, out);
        }
        out.close();
    }
}

class Solver {
    int r1, r2, c1, c2, d1, d2;
    int[][] a = new int[2][2];
    void solve(int test_number, InputReader in, PrintWriter out) throws IOException {
        r1 = in.nextInt();
        r2 = in.nextInt();
        c1 = in.nextInt();
        c2 = in.nextInt();
        d1 = in.nextInt();
        d2 = in.nextInt();
        boolean ok = false;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 && i + l == d1 && j + k == d2 && (i != j && i != k && i != l && j != k && j != l && k != l)) {
                            ok = true;
                            a[0][0] = i;
                            a[0][1] = j;
                            a[1][0] = k;
                            a[1][1] = l;
                            break;
                        }
                    }
                    if (ok) break;
                }
                if (ok) break;
            }
            if (ok) break;
        }
        if (ok) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0;  j < 2; j++) {
                    out.print(a[i][j] + " ");
                }
                out.println();
            }
        } else out.println(-1);
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