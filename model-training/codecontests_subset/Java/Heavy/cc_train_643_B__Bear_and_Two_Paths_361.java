

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ProblemD {
    private IOManager io = new IOManager();

    private void solve() throws IOException {
        int[] ar1 = io.rInts();
        int n = ar1[0];
        int k = ar1[1];
        ar1 = io.rInts();
        int a = ar1[0];
        int b = ar1[1];
        int c = ar1[2];
        int d = ar1[3];

        if (n == 4) {
            System.out.println(-1);
            return;
        }

        int minK = 4 + (n - 4 - 1) + 2;
        if (k < minK) {
            System.out.println(-1);
            return;
        }

        List<Integer> midRoad = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i == a || i == b || i == c || i == d) {
                continue;
            }
            midRoad.add(i);
        }

        printRoad(midRoad, a, d, c, b);
        System.out.println();
        printRoad(midRoad, c, b, a, d);
    }

    void printRoad(List<Integer> midRoad, int a, int b, int c, int d) {
        System.out.print(a + " " + b);
        for (Integer road : midRoad) {
            System.out.print(" " + road);
        }
        System.out.print(" " + c + " " + d);
    }

    class IOManager {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        private static final String SEPARATOR = " ";

        private int[] rInts() throws IOException {
            String[] readLine = bf.readLine().split(SEPARATOR);
            int[] ret = new int[readLine.length];
            int idx = 0;
            for (String s : readLine) {
                ret[idx++] = Integer.parseInt(s);
            }
            return ret;
        }

        int[] rLong() throws IOException {
            String[] readLine = bf.readLine().split(SEPARATOR);
            int[] ret = new int[readLine.length];
            int idx = 0;
            for (String s : readLine) {
                ret[idx++] = Integer.parseInt(s);
            }
            return ret;
        }

        void print(int... objectArray) {
            for (Object o : objectArray) {
                System.out.print(o + SEPARATOR);
            }
            System.out.println();
        }
    }

    public static void main(String... args) throws IOException {
        new ProblemD().solve();
    }
}
