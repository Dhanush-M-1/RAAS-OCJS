import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author madi.sagimbekov
 */
public class C1107D {

    private static BufferedReader in;
    private static BufferedWriter out;

    private static List<Integer>[] list;
    private static int[] arr;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        open();

        Map<Character, int[]> map = new HashMap<>();
        map.put('0', new int[]{0, 0, 0, 0});
        map.put('1', new int[]{0, 0, 0, 1});
        map.put('2', new int[]{0, 0, 1, 0});
        map.put('3', new int[]{0, 0, 1, 1});
        map.put('4', new int[]{0, 1, 0, 0});
        map.put('5', new int[]{0, 1, 0, 1});
        map.put('6', new int[]{0, 1, 1, 0});
        map.put('7', new int[]{0, 1, 1, 1});
        map.put('8', new int[]{1, 0, 0, 0});
        map.put('9', new int[]{1, 0, 0, 1});
        map.put('A', new int[]{1, 0, 1, 0});
        map.put('B', new int[]{1, 0, 1, 1});
        map.put('C', new int[]{1, 1, 0, 0});
        map.put('D', new int[]{1, 1, 0, 1});
        map.put('E', new int[]{1, 1, 1, 0});
        map.put('F', new int[]{1, 1, 1, 1});

        int n = readInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int col = 0;
            char[] c = readString().toCharArray();
            for (char ch : c) {
                for (int v : map.get(ch)) {
                    matrix[i][col++] = v;
                }
            }
        }

        List<Integer> divs = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divs.add(i);
                if (n / i != i) {
                    divs.add(n / i);
                }
            }
        }

        Collections.sort(divs, Collections.reverseOrder());

        /*int left = 0;
        int right = divs.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = divs.get(mid);
            if (isOk(matrix, n, val)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        out.write(divs.get(left - 1) + "\n");*/

        int val = 1;
        for (int div : divs) {
            if (isOk(matrix, n, div)) {
                val = div;
                break;
            }
        }

        out.write(val + "\n");

        close();
    }

    private static boolean isOk(int[][] mat, int n, int d) {
        int size = n / d;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int val = -1;
                for (int x = 0; x < d; x++) {
                    for (int y = 0; y < d; y++) {
                        if (val == -1) {
                            val = mat[i * d + x][j * d + y];
                        } else {
                            if (mat[i * d + x][j * d + y] != val) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
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
