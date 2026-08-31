import java.io.*;
import java.util.*;

public class Main {
    class Reader {
        BufferedReader in;

        Reader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String name) throws IOException {
            in = new BufferedReader(new FileReader(name));
        }

        StringTokenizer tokin = new StringTokenizer("");

        String next() throws IOException {
            if (!tokin.hasMoreTokens())
                tokin = new StringTokenizer(in.readLine());
            return tokin.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    long MOD(long a) {
        if (a < 0)
            a = -a;
        return a;
    }

    void slave() throws IOException {
        Reader in = new Reader();
        int n = in.nextInt();
        long arr[] = new long[n];
        long d[] = new long[n];
        long c[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            long a = arr[i];
            if (n - i < n)
                c[n - i] += MOD(a - 1) - MOD(a - n);
            if (a - i - 1 > -1)
                d[(int) (a - i - 1)] += 2;
            else
                d[(int) (n + a - i - 1)] += 2;
            if (n - i < n)
                d[n - i] += -2;
        }
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += MOD(arr[i] - i - 1);
        }
        for (int i = 0; i < n - 1; i++) {
            sum2 += MOD(arr[i] - i - 2);
        }
        sum2 += MOD(arr[n - 1] - 1);
        d[0] = sum2 - sum1 - c[1];
        long min = sum1;
        long mink = 0;
        long cur = sum1;
        long de = d[0];
        //System.out.println(sum1);
        for (int k = 1; k < n; k++) {
            cur += c[k] + de;
            de += d[k];
            if (cur < min) {
                min = cur;
                mink = k;
            }
            //System.out.println(cur);
        }
        System.out.print(min + " " + mink);
    }

    public static void main(String args[]) throws IOException {
        new Main().slave();
    }
}
