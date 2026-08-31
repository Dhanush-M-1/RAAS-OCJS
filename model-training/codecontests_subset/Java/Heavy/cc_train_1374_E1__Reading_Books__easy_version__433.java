import java.io.*;
import java.util.*;
import java.math.*;

public class E1 {
    static final boolean RUN_TIMING = false;
    static char[] inputBuffer = new char[1 << 20];
    static PushbackReader in = new PushbackReader(new BufferedReader(new InputStreamReader(System.in)), 1 << 20);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public void go() throws IOException {
        // in = new PushbackReader(new BufferedReader(new FileReader(new File("test.txt"))), 1 << 20);
        // out = new PrintWriter(new FileWriter(new File("output.txt")));
        int n = ipar();
        int k = ipar();
        int a = 0;
        int b = 0;
        int[][] books = new int[n][];
        ArrayList<int[]> left = new ArrayList<>();
        ArrayList<int[]> right = new ArrayList<>();
        ArrayList<int[]> all = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            books[i] = iapar(3);
            sum += books[i][0];
            a += books[i][1];
            b += books[i][2];
            if (books[i][1] == 1 && books[i][2] == 0) {
                left.add(books[i]);
            } else if (books[i][1] == 0 && books[i][2] == 1) {
                right.add(books[i]);
            } else if (books[i][1] == 1 && books[i][2] == 1) {
                all.add(books[i]);
            }
        }
        if (a < k || b < k) {
            out.println(-1);
            return;
        }
        Collections.sort(left, this::compare);
        Collections.sort(right, this::compare);
        for (int i = 0; i < Math.min(left.size(), right.size()); i++) {
            int[] l = left.get(i);
            int[] r = right.get(i);
            all.add(new int[]{l[0] + r[0], 1, 1});
        }
        Collections.sort(all, this::compare);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += all.get(i)[0];
        }
        out.println(ans);
    }

    public int compare(int[] a, int[] b) {
        return a[0] - b[0];
    }

    public int ipar() throws IOException {
        return Integer.parseInt(spar());
    }

    public int[] iapar(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ipar();
        }
        return arr;
    }

    public long lpar() throws IOException {
        return Long.parseLong(spar());
    }

    public long[] lapar(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = lpar();
        }
        return arr;
    }

    public double dpar() throws IOException {
        return Double.parseDouble(spar());
    }

    public String spar() throws IOException {
        int len = 0;
        int c;
        do {
            c = in.read();
        } while (Character.isWhitespace(c) && c != -1);
        if (c == -1) {
            throw new NoSuchElementException("Reached EOF");
        }
        do {
            inputBuffer[len] = (char)c;
            len++;
            c = in.read();
        } while (!Character.isWhitespace(c) && c != -1);
        while (c != '\n' && Character.isWhitespace(c) && c != -1) {
            c = in.read();
        }
        if (c != -1 && c != '\n') {
            in.unread(c);
        }
        return new String(inputBuffer, 0, len);
    }

    public String linepar() throws IOException {
        int len = 0;
        int c;
        while ((c = in.read()) != '\n' && c != -1) {
            if (c == '\r') {
                continue;
            }
            inputBuffer[len] = (char)c;
            len++;
        }
        return new String(inputBuffer, 0, len);
    }

    public boolean haspar() throws IOException {
        String line = linepar();
        if (line.isEmpty()) {
            return false;
        }
        in.unread('\n');
        in.unread(line.toCharArray());
        return true;
    }

    public static void main(String[] args) throws IOException {
        long time = 0;
        time -= System.nanoTime();
        new E1().go();
        time += System.nanoTime();
        if (RUN_TIMING) {
            System.out.printf("%.3f ms%n", time / 1000000.0);
        }
        out.flush();
        in.close();
    }
}
