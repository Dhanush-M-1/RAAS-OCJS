import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
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
        int citizens = nextInt(), wizards = nextInt(), percent = nextInt();
        int needCitizens = (int) Math.ceil(citizens / 100d * percent), answer = Math.max(0, needCitizens - wizards);
        writer.println(answer);
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
