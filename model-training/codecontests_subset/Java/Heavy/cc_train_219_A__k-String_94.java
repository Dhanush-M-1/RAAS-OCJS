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

        int k = ir.nextInt();
        String line = ir.next();
        StringBuilder newLine = new StringBuilder();
        int [] letters = new int[26];

        for (int i = 0, num; i < line.length(); i++) {
            num = (int)line.charAt(i) - 97;
            letters[num]++;
        }

        for (int i = 0, num; i < 26; i++) {
            num = letters[i];
            if (num > 0) {
                if (num % k == 0) {
                    for (int l = 0; l < num / k; l++) newLine.append((char)(i + 97));
                }
                else {
                    pw.print("-1");
                    return;
                }
            }
        }

        for (int i = 0; i < k; i++) pw.print(newLine);

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