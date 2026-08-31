import java.io.*;
import java.util.*;

/**
 * Created by Arthur on 3/14/2015.
 */
public class Main {

    public static void main(String[] args) {
        new Main(args.length != 0);
    }

    Main(boolean files) {
        initIO(files);
        solve();
        close();
    }

    FastScanner sc;
    PrintWriter pw;

    private void initIO(boolean files) {
        if (files) {
            sc = new FastScanner("input.txt");
            try {
                pw = new PrintWriter(new FileOutputStream("output.txt"), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            sc = new FastScanner(System.in);
            pw = new PrintWriter(System.out);
        }
    }

    private void close() {
        sc.close();
        pw.close();
    }

    static final int N = 5000500;

    int k[] = new int[100];
    int k1[] = new int[100];
    int k2[] = new int[100];

    private void solve() {
        String source = sc.next();
        String a = sc.next();
        String b = sc.next();
        for (int i = 0; i < source.length(); i++) {
            k[source.charAt(i) - 'a']++;
        }
        for (int i = 0; i < a.length(); i++) {
            k1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            k2[b.charAt(i) - 'a']++;
        }
        int m1 = 0;
        int m2 = 0;
        mainfor:
        for (int i = 0; ; i++) {
            int d = 2000000000;
            for (int j = 0; j < 26; j++) {
                if (k1[j] * i > k[j]) {
                    break mainfor;
                }
                if (k2[j] != 0) d = Math.min(d, (k[j] - k1[j] * i) / k2[j]);
            }
            if (i + d > m1 + m2) {
                m1 = i;
                m2 = d;
            }
        }
        for (int i = 0; i < m1; i++) {
            pw.print(a);
            for (int j = 0; j < 26; j++) k[j] -= k1[j];
        }
        for (int i = 0; i < m2; i++) {
            pw.print(b);
            for (int j = 0; j < 26; j++) k[j] -= k2[j];
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < k[i]; j++) pw.print((char) (i + 'a'));
        }
    }
}

class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    FastScanner(String file) {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        st = new StringTokenizer("");
    }

    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
        st = new StringTokenizer("");
    }

    String next() {
        try {
            while (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class VectorInt {
    int capacity = 2;
    int d[] = new int[capacity];
    int size = 0;

    VectorInt() {
    }

    public VectorInt(int n) {
        this();
        setSize(n);
    }

    void add(int x) {
        if (size == capacity) grow();
        d[size++] = x;
    }

    void remove() {
        if (size == 0) throw new IndexOutOfBoundsException();
        size--;
    }

    private void grow() {
        capacity = size + (size >> 1);
        d = Arrays.copyOf(d, capacity);
    }

    private void grow(int newSize) {
        capacity = newSize;
        d = Arrays.copyOf(d, capacity);
    }

    void setSize(int newSize) {
        if (newSize > capacity) {
            grow(newSize);
        }
        size = newSize;
    }

    public void readIn(FastScanner sc, int n) {
        int lastSize = size;
        setSize(size + n);
        for (int i = 0; i < n; i++) {
            d[lastSize + i] = sc.nextInt();
        }
    }

    public void print(PrintWriter pw) {
        for (int i = 0; i < size; i++) {
            pw.print(d[i] + " ");
        }
        pw.println();
    }

    public void sort(int l, int r) {
        Arrays.sort(d, l, r);
    }

    public void sort() {
        sort(0, size);
    }
}