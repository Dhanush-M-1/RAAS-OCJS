import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class C {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static PrintWriter writer;

    static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));

        writer = new PrintWriter(System.out);
    }

    static String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                System.out.println(e);
                System.exit(1);
            }
        return tokenizer.nextToken();
    }

    static byte nextByte() {
        return Byte.parseByte(nextToken());
    }

    static short nextShort() {
        return Short.parseShort(nextToken());
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static float nextFloat() {
        return Float.parseFloat(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    static void solve() {
        long num = nextLong();

        byte numDivisors = 0;
        long turn = 1;
        step:
        for (long i = 2; i * i <= num; i++)
            while (num % i == 0) {
                numDivisors++;
                if (numDivisors > 2) break step;
                num /= i;
                turn *= i;
            }
        if (num > 1) numDivisors++;

        if (numDivisors == 2) writer.println(2);
        else {
            writer.println(1);
            if (numDivisors > 2) writer.println(turn);
            else writer.println(0);
        }
    }

    static void close() {
        try {
            reader.close();

            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        init();
        solve();
        close();
    }
}
