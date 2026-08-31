

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {
    private IOManager io = new IOManager();

    private void solve() throws IOException {
        int[] ints = io.rInts();
        int n = ints[0];
        int k = ints[1];
        int[] tab = io.rInts();

        int sum = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            sum += i + 1;
            if (sum > k) {
                int prev = sum - (i+1);
                ret = k - prev - 1;
                break;
            } else if (sum == k) {
                ret = i;
                break;
            }

        }

         System.out.print(tab[ret]);
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
        new ProblemB().solve();
    }
}
