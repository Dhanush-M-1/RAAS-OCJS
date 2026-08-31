import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public void solve() throws IOException {
        int t = nextInt();
        for (int tt = 0; tt < t; tt++) {
            long a = nextLong(), b = nextLong(), c = nextLong(), d = nextLong();
            if (a < b) {
                out.println("No");
            } else if (a % b > c) {
                out.println("No");
            } else if (d < b) {
                out.println("No");
            } else if(c >= b){
                out.println("Yes");
            } else if(d % b == 0){
                out.println("Yes");
            }else{
                a %= b;
                d %= b;
                long gcd = gcd(d, b);
                if(b - c > d){
                    out.println("No");
                }else if(b - c > gcd){
                    out.println("No");
                }else if((a + gcd - 1)/gcd*gcd - a < b - c && (a + gcd - 1)/gcd*gcd - a != 0){
                    out.println("No");
                }else{
                    out.println("Yes");
                }
            }

        }
    }

    BufferedReader br;
    StringTokenizer sc;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Main().run();
    }

    public void run() throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String nextToken() throws IOException {
        while (sc == null || !sc.hasMoreTokens()) {
            try {
                sc = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return sc.nextToken();
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
}