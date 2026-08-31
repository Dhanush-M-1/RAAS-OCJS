import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author madi.sagimbekov
 */
public class C1037B {

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        open();

        int[] ns = readInts();
        int n = ns[0];
        int s = ns[1];

        int[] a = readInts();

        Arrays.sort(a);
        long res = Math.abs(s - a[n / 2]);
        if (res == 0) {
            out.write("0\n");
        } else if (s > a[n / 2]) {
            for (int i = n / 2 + 1; i < n; i++) {
                if (a[i] < s) {
                    res += s - a[i];
                }
            }
            out.write(res + "\n");
        } else {
            for (int i = 0; i < n / 2; i++) {
                if (a[i] > s) {
                    res += a[i] - s;
                }
            }
            out.write(res + "\n");
        }

        close();
    }

    private static int[] readInts() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    private static long[] readLongs() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }

    private static long readLong() throws IOException {
        return Long.parseLong(in.readLine());
    }

    private static double[] readDoubles() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(in.readLine());
    }

    private static String readString() throws IOException {
        return in.readLine();
    }

    private static void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter((System.out)));
    }

    private static void close() throws IOException {
        out.flush();
        out.close();
        in.close();
    }

}
