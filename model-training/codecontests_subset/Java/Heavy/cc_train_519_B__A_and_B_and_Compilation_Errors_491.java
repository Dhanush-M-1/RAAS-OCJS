
import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import sun.misc.Queue;

//<editor-fold defaultstate="collapsed" desc=" Fast Scanner">
/**
 *
 * @author Mojtaba
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        MyScanner in = new MyScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");

        int n = in.nextInt();
        HashMap<Integer, Integer>[] maps = new HashMap[3];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < n - i; j++) {
                int t = 1;
                int x = in.nextInt();
                if (maps[i].containsKey(x)) {
                    t += maps[i].get(x);
                }
                maps[i].put(x, t);
            }
        }
        sb.append(f(maps[0], maps[1]));
        sb.append("\n");
        sb.append(f(maps[1], maps[2]));


        writer.println(sb.toString());
        writer.close();
        in.close();
    }

    private static int f(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        for (Map.Entry<Integer, Integer> entry1 : map2.entrySet()) {
            int x = entry1.getKey();
            int t = entry1.getValue();
            for (int i = 0; i < t; i++) {
                int t2 = map1.get(x);
                if (t2 == 1) {
                    map1.remove(x);
                } else {
                    map1.put(x, t2 - 1);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map1.keySet());
        return list.get(0);
    }
}

class MyScanner {

    BufferedReader reader;
    StringTokenizer tokenizer;

    public MyScanner(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public int[] nextIntegerArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public int nextInt(int radix) throws IOException {
        return Integer.parseInt(next(), radix);
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public long nextLong(int radix) throws IOException {
        return Long.parseLong(next(), radix);
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    public BigInteger nextBigInteger(int radix) throws IOException {
        return new BigInteger(next(), radix);
    }

    public String next() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
            return this.next();
        }
        return tokenizer.nextToken();
    }

    public void close() throws IOException {
        this.reader.close();
    }
}
//</editor-fold>
