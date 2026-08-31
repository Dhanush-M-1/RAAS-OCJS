import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author madi.sagimbekov
 */
public class C1155A {

    private static BufferedReader in;
    private static BufferedWriter out;

    private static List<Integer>[] list;
    private static int[] arr;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        open();

        int n = readInt();
        char[] str = readString().toCharArray();

        for (int i = 0; i < n - 1; i++) {
            if (str[i] > str[i + 1]) {
                out.write("YES\n" + (i + 1) + " " + (i + 2) + "\n");
                close();
                return;
            }
        }

        out.write("NO\n");

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

    private static List<Integer>[] buildAdjacencyList(int n, int m) throws IOException {
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] e = readInts();
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        return list;
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
