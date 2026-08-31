import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Main implements Runnable {
 
    // Variable declarations
    String regex = "[0-3][0-9]-[0-1][0-9]-201[3-5]";
    String inp;
    // End of declarations
 
    private void read() throws IOException {
        // Read input
        inp = nextToken();
    }
 
    private void solve() {
        // Logic code
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);
        int max = 0;
        int start = 0;
        String maxs = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (m.find(start)) {
            String t = inp.substring(m.start(), m.end());
            start = m.start() + 1;
            if (!isValid(t)) continue;
            //System.out.println(t);
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
            if (map.get(t) > max) {
                max = map.get(t);
                maxs = t;
            }
        }
        out.println(maxs);
    }
    
    private boolean isValid(String s) {
        String[] p = s.split("-");
        int month = Integer.parseInt(p[1]);
        int day = Integer.parseInt(p[0]);
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (day > 0 && day < 32) return true;
            return false;
        case 2:
            if (day > 0 && day < 29) return true;
            return false;
        case 4:
        case 6:
        case 9:
        case 11:
            if (day > 0 && day < 31) return true;
            return false;
        default:
            return false;
        }
    }
 
    //=========================TEMPLATE=======================//
 
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tokenizer;
    private final int INF = (1 << 31) - 1;
    private final double EPS = 1e-6;
    private final double PI = Math.acos(0.0) * 2;
    private int nTest = 1;
 
    @Override
    public void run() {
        try {
            init();
            // nTest = nextInt();
            for (int i = 1; i <= nTest; i++) {
                read();
                //out.print("Case " + i + ": ");
                solve();
                // System.gc();
            }
            // in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
 
    private void init() throws FileNotFoundException {
        in = new BufferedReader(new InputStreamReader(System.in));
        //in = new BufferedReader(new FileReader(new File("in.txt")));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                System.out)));
    }
 
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
 
    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }
 
    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
 
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
 
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
    
    private void printArray(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print((i == 0 ? "" : " ") + a[i]);
        }
        System.out.println();
    }
 
    private void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[0].length; ++j) {
                System.out.print((j == 0 ? "" : " ") + a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
