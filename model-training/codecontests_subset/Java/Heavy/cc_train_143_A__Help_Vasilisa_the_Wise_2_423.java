import java.io.*;
import java.util.*;


public class TestGenerator {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        r1 = sc.nextInt();
        r2 = sc.nextInt();
        c1 = sc.nextInt();
        c2 = sc.nextInt();
        d1 = sc.nextInt();
        d2 = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j)
                    continue;
                for (int k = 1; k <= 9; k++) {
                    if(k == i || k == j)
                        continue;
                    for (int l = 1; l <= 9; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        if(i + j == r1 && k + l == r2 && i + k == c1
                        && j + l == c2 && i + l == d1 && j + k == d2) {
                            print(i, j, k, l);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);

        out.close();
    }
    static int r1, r2, c1, c2, d1, d2;
    static void print(int i, int j, int k, int l){
        System.out.println(i + " " + j + "\n" + k + " " + l);
    }
}

class Scanner
{
    StringTokenizer st;
    BufferedReader br;

    public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

    public String next() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {return Integer.parseInt(next());}

    public long nextLong() throws IOException {return Long.parseLong(next());}

    public String nextLine() throws IOException {return br.readLine();}

    public double nextDouble() throws IOException
    {
        String x = next();
        StringBuilder sb = new StringBuilder("0");
        double res = 0, f = 1;
        boolean dec = false, neg = false;
        int start = 0;
        if(x.charAt(0) == '-')
        {
            neg = true;
            start++;
        }
        for(int i = start; i < x.length(); i++)
            if(x.charAt(i) == '.')
            {
                res = Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                dec = true;
            }
            else
            {
                sb.append(x.charAt(i));
                if(dec)
                    f *= 10;
            }
        res += Long.parseLong(sb.toString()) / f;
        return res * (neg?-1:1);
    }

    public boolean ready() throws IOException {return br.ready();}


}
