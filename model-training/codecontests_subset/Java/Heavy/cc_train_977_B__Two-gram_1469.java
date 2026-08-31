import java.io.*;
import java.util.*;

public class App {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        } // reads in the next int

        public long nextLong() {
            return Long.parseLong(next());
        } // reads in the next long

        public double nextDouble() {
            return Double.parseDouble(next());
        } // reads in the next double
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        // YOUR CODE HERE
        int length = r.nextInt();
        String[] arr = r.next().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            String letterCombo = arr[i] + arr[i + 1];
            if (map.containsKey(letterCombo)) {
                map.put(letterCombo, map.get(letterCombo) + 1);
            } else {
                map.put(letterCombo, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String answer = "";
        for (String i : map.keySet()) {
            if (map.get(i) > max) {
                answer = i;
                max = map.get(i);
            }
        }
        pw.println(answer);
        pw.close(); // flushes the output once printing is done
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            pw.print(i + " ");
        }
    }

    public static char[] alphabetArray() {
        char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };
        return arr;
    }
}