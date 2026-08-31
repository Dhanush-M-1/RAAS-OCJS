import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class A {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();
        int[] tmp = scanner.nextIntArray();
        int n = tmp[0]; int x = tmp[1]; int y = tmp[2];
        char[] str = scanner.nextLine().toCharArray();
        int count = 0;
        for (int i = n - 1; i >= n - y; i--) {
            if (str[i] != '0') {
                //System.out.println("!" + str[i]);
                count++;
            }
        }
        if (str[n - y - 1] != '1')
            count++;

        for (int i = n - y - 2; i >= max(0, n - x); i--) {
            if (str[i] != '0') {
                //System.out.println(str[i]);
                count++;
            }
        }
        System.out.println(count);
    }

    private static class FastScanner {
        private BufferedReader br;

        public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public int[] nextIntArray() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            int[] array = new int[strings.length];
            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(strings[i]);
            return array;
        }
        public String nextLine() throws IOException { return br.readLine(); }
    }
}
