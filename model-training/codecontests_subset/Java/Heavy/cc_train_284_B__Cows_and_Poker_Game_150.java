import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
    ArrayList<String> v = new ArrayList<String>();

    void solve() throws IOException {
        int n = si();
        String s = ss();
        int i = 0, a = 0;
        for (char c : s.toCharArray()) {
            if (c == 'I')
                i++;
            if (c !='F')
                a++;
        }
        if (i == 1) {
            System.out.println(1);
            return;
        } else if (i > 1) {
            System.out.println(0);
            return;
        } else {
            System.out.println(a);
        }

    }

    public static void main(String[] Args) throws IOException {
        new B().solve();
    }

    static int[] dx_ = { 0, 0, 1, -1 };
    static int[] dy_ = { 1, -1, 0, 0 };

    // ----------------------- Library ------------------------

    // ----------------------- GRAPH ------------------------

    /**
     * important for speed!!! PrintWriter out=new PrintWriter(new
     * OutputStreamWriter(System.out)); out.print(...); out.close();
     * 
     * @param v
     */
    // leap year is 29
    int[] year = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    void initSystem() throws IOException {
        if (br != null)
            br.close();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    void initFile() throws IOException {
        if (br != null)
            br.close();
        br = new BufferedReader(new InputStreamReader(new FileInputStream(
                "input.txt")));
    }

    void printWriter() {
        try {
            PrintWriter pr = new PrintWriter("output.txt");
            pr.println("hello world");
            pr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void comparator() {
        Point[] v = new Point[10];
        Arrays.sort(v, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.x != b.x)
                    return -(a.x - b.x);
                return a.y - b.y;
            }
        });
    }

    double distance(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    Scanner in = new Scanner(System.in);

    String ss() {
        return in.next();
    }

    char[] sc() {
        return in.next().toCharArray();
    }

    String sline() {
        return in.nextLine();
    }

    int si() {
        return in.nextInt();
    }

    long sl() {
        return in.nextLong();
    }

    int[] sai(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    int[] si(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    String[] ss(int n) {
        String[] a = new String[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = ss();
        }
        return a;
    }

    int[] sai_(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    BufferedReader br;
    StringTokenizer tokenizer;
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    void tok() throws IOException {
        tokenizer = new StringTokenizer(br.readLine());
    }

    int toki() throws IOException {

        return Integer.parseInt(tokenizer.nextToken());
    }

    int[] rint(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(tokenizer.nextToken());

        return a;
    }

    int[] rint_(int n) throws IOException {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(tokenizer.nextToken());

        return a;
    }

    String[] rstrlines(int n) throws IOException {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }
        return a;
    }

    long tokl() {
        return Long.parseLong(tokenizer.nextToken());
    }

    double tokd() {
        return Double.parseDouble(tokenizer.nextToken());
    }

    String toks() {
        return tokenizer.nextToken();
    }

    String rline() throws IOException {
        return br.readLine();
    }

    List<Integer> toList(int[] a) {
        List<Integer> v = new ArrayList<Integer>();
        for (int i : a)
            v.add(i);
        return v;
    }

    static void pai(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    static int toi(Object s) {
        return Integer.parseInt(s.toString());
    }

    static int[] dx3 = { 1, -1, 0, 0, 0, 0 };
    static int[] dy3 = { 0, 0, 1, -1, 0, 0 };
    static int[] dz3 = { 0, 0, 0, 0, 1, -1 };

    static int[] dx = { 1, 0, -1, 1, -1, 1, 0, -1 }, dy = { 1, 1, 1, 0, 0, -1,
            -1, -1 };

    static int INF = 2147483647; // =2^31-1 // -8
    static long LINF = 922337203854775807L; // -8
    static short SINF = 32767; // -32768

    // finds GCD of a and b using Euclidian algorithm
    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    static List<String> toList(String[] a) {
        return Arrays.asList(a);
    }

    static String[] toArray(List<String> a) {
        String[] o = new String[a.size()];
        a.toArray(o);
        return o;
    }

    static int[] pair(int... a) {
        return a;
    }
}