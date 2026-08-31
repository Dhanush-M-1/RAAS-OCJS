
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class A1008 {
    public static void main(String [] args) /*throws Exception*/ {
        InputStream inputReader = System.in;
        OutputStream outputReader = System.out;
        InputReader in = new InputReader(inputReader);//new InputReader(new FileInputStream(new File("input.txt")));new InputReader(inputReader);
        PrintWriter out = new PrintWriter(outputReader);//new PrintWriter(new FileOutputStream(new File("output.txt")));
        Algorithm solver = new Algorithm();
        solver.solve(in, out);
        out.close();
    }
}

class Algorithm {
    void solve(InputReader ir, PrintWriter pw) {

        int q = ir.nextInt();

        for (int i = 0; i < q; i++) {
            int l = ir.nextInt(), r = ir.nextInt(), d = ir.nextInt();

            if (d < l) {
                pw.println(d);
            } else {
                long num = r - r % d + d;
                if (num <= r) num += d;
                pw.println(num);
            }

        }

    }

    private static void mergeSort(int[] array) {
        if(array.length == 1)
            return;
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, array);
    }

    private static void merge(int[] first, int[] second, int[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            }
            else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    String nextLine(){
        String fullLine;
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                fullLine = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return fullLine;
        }
        return null;
    }

    String [] toArray() {
        return nextLine().split(" ");
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
    double nextDouble() {
        return Double.parseDouble(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }

}