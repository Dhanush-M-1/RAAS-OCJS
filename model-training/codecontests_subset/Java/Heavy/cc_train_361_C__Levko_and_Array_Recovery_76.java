import java.io.*;
import static java.lang.Math.*;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.function.*;
import java.lang.*;

public class Main {
    final static boolean debug = false;
    final static String fileName = "";
    final static boolean useFiles = false;

    public static void main(String[] args) throws FileNotFoundException {
        long start;
        if (debug)
            start = System.nanoTime();
        InputStream inputStream;
        OutputStream outputStream;
        if (useFiles) {
            inputStream = new FileInputStream(fileName + ".in");
            outputStream = new FileOutputStream(fileName + ".out");
        } else {
            inputStream = System.in;
            outputStream = System.out;
        }
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task(in, out);
        solver.solve();
        if(debug)
            out.println((System.nanoTime() - start) / 1e+9);
        out.close();
    }
}
class Task {
    public void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        Arrays.fill(a, (int)1e9);
        int[] d = new int[n];

        int[] l = new int[m];
        int[] r = new int[m];
        int[] mm = new int[m];
        int[] t = new int[m];
        for (int i = 0; i < m; i++) {
            t[i] = in.nextInt();
            l[i] = in.nextInt() - 1;
            r[i] = in.nextInt() - 1;
            mm[i] = in.nextInt();
            if (t[i] == 1) {
                for (int j = l[i]; j <= r[i]; j++) {
                    d[j] += mm[i];
                }
            } else {
                for (int j = l[i]; j <= r[i]; j++) {
                    a[j] = min(a[j], mm[i] - d[j]);
                }
            }
        }
        for (int i = 0; i < n; i++) d[i] = a[i];
        for (int i = 0; i < m; i++){
            if (t[i] == 1){
                for (int j = l[i]; j <= r[i]; j++)
                    d[j] += mm[i];
            }
            else{
                int mx = (int)-1e9;
                for (int j = l[i]; j <= r[i]; j++)
                    mx = max(mx, d[j]);
                if (mx != mm[i]){
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++)
            out.print(a[i] + " ");
    }

    private InputReader in;
    private PrintWriter out;

    Task(InputReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public double nextDouble(){
        return Double.parseDouble(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong(){
        return Long.parseLong(next());
    }

    public byte nextByte(){
        return Byte.parseByte(next());
    }
}
