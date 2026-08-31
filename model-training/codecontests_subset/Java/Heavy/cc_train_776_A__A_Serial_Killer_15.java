import java.io.*;
import java.util.*;

public class A1008 {
    public static void main(String [] args) {
        InputStream inputReader = System.in;
        OutputStream outputReader = System.out;
        InputReader in = new InputReader(inputReader);
        PrintWriter out = new PrintWriter(outputReader);
        Algorithm solver = new Algorithm();
        solver.solve(in, out);
        out.close();
    }
}

class Algorithm {
    void solve(InputReader ir, PrintWriter pw) {

        String name1 = ir.next(), name2 = ir.next(), nameN1, nameN2;
        pw.println(name1 + " " + name2);
        int n = ir.nextInt();

        for (int i = 0; i < n; i++) {
            nameN1 = ir.next();
            nameN2 = ir.next();
            if (nameN1.equals(name1)) name1 = nameN2;
            else if (nameN2.equals(name1)) name1 = nameN1;
            else if (nameN1.equals(name2)) name2 = nameN2;
            else name2 = nameN1;
            pw.println(name1 + " " + name2);
        }

    }

    boolean isPolyndrom(String str) {
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) newStr.append(str.charAt(i));
        return newStr.toString().equals(str);
    }

    private static void Qsort(int[] array, int low, int high) {

        int i = low;
        int j = high;
        int x = array[low + (high - low) / 2];

        do {
            while (array[i] < x) ++i;
            while (array[j] > x) --j;
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) Qsort(array, low, j);
        if (i < high) Qsort(array, i, high);

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
        String fullLine = null;
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                fullLine = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return fullLine;
        }
        return fullLine;
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