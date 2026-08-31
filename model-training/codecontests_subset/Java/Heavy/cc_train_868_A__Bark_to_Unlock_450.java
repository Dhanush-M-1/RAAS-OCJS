import java.io.*;
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

        String password = ir.next();
        int n = ir.nextInt();
        String line = "";
        int [] first = new int[2], second = new int[1];
        char one = password.charAt(0), two = password.charAt(1);

        for (int i = 0; i < n; i++) line = line + ir.next();
        char [] tries = line.toCharArray();

        for (int i = 1; i < n * 2; i++) {
            if ((tries[i - 1] == one && tries[i] == two) || (tries[i - 1] == two && tries[i] == one)) {
                pw.print("YES");
                return;
            }
        }

        for (int i = 0; i < n * 2; i++) {
            if (tries[i] == one && i % 2 == 0) first[0]++;
            else if (tries[i] == one && i % 2 == 1) first[1]++;
            else if (tries[i] == two && i % 2 == 0) second[0]++;
        }

        if (first[1] > 0 && second[0] > 0 || (first[0] > 0 && first[1] > 0 && one == two)) pw.print("YES");
        else pw.print("NO");
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