import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Math.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Reader.init(System.in);
        int n = Reader.nextInt();
        ArrayList<Long> arr = new ArrayList();
        ArrayList<Long> ar = new ArrayList();
        HashMap<Long, Integer> map = new HashMap();
        HashMap<Long, Integer> mapp = new HashMap();

        for (int i = 0; i < n; i++) {
            long x = Reader.nextLong();
            arr.add(x);
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            long x = Reader.nextLong();
            if (mapp.containsKey(x)) {
                mapp.put(x, mapp.get(x) + 1);
            } else {
                mapp.put(x, 1);
            }
            if (map.containsKey(x)) {
                map.put(x, map.get(x) - 1);
            }
            ar.add(x);
        }
        for (int i = 0; i < n - 2; i++) {
            long x = Reader.nextLong();
            if (mapp.containsKey(x)) {
                mapp.put(x, mapp.get(x) - 1);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (map.get(arr.get(i)) != null && map.get(arr.get(i)) > 0) {
                System.out.println(arr.get(i));
                break;
            }
        }
        for (int i = 0; i < ar.size(); i++) {
            if (mapp.get(ar.get(i)) != null && mapp.get(ar.get(i)) > 0) {
                System.out.println(ar.get(i));
                break;
            }
        }

    }

    static int prime(int p) {
        int t = (int) sqrt(Integer.parseInt(p + ""));
        if (t <= 1) {
            return 0;
        }
        for (long i = 2; i <= t; i++) {
            if (p % i == 0) {
                return 0;
            }

        }
        return 1;
    }

    static int Obe(long a, long b) {
        BigInteger b1 = new BigInteger("" + a);
        BigInteger b2 = new BigInteger("" + b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    static int che(int[] w) {
        Set<Integer> list = new LinkedHashSet<>();
        for (int i = 0; i < w.length; i++) {
            list.add(w[i]);
        }
        return list.size();
    }

    private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();

    static {
        fibCache.add(BigInteger.ZERO);
        fibCache.add(BigInteger.ONE);
    }

    public static BigInteger fib(int n) {
        if (n >= fibCache.size()) {
            fibCache.add(n, fib(n - 1).add(fib(n - 2)));
        }

        return fibCache.get(n);
    }

}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());

    }

}
