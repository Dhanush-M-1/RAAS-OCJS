import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private static class Geometry {
        public static boolean check3DotsOnLine(int x1, int y1, int x2, int y2, int x3, int y3) {
            return ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) == 0;
        }
        
        public static boolean check3DotsOnLine(long x1, long y1, long x2, long y2, long x3, long y3) {
            return ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) == 0;
        }
    }
    
    private static class Util {
        public static int gcd(int p, int q) {
            if (q == 0) return p;
            int r = p % q;
            return gcd(q, r);
        }
        
        public static long gcd(long p, long q) {
            if (q == 0) return p;
            long r = p % q;
            return gcd(q, r);
        }
    }
    
    public static Scanner sc;
    public static PrintWriter pw;
    
    public static void main(String[] args) throws FileNotFoundException {
        
        if (fileInOut) {
            sc = new Scanner(new File(inFile));
            pw = new PrintWriter(new File(outFile));
        } else {
            sc = new Scanner(System.in);
            pw = new PrintWriter(System.out);
        }
        
        new Main().run();
        
        sc.close();
        pw.flush();
        pw.close();
    }
    
    public static final boolean fileInOut = false;
    public static final String inFile = "longpath.in";
    public static final String outFile = "longpath.out";
    
    private void run() {
        readData();
        solve();
    }
    
    int n;
    String str;
    
    private void readData() {
        n = sc.nextInt();
        str = sc.next();
    }
    
    private void solve() {
        for (int i=0;i<n;i++) {
            for (int j=1;j<=n;j++) {
                int k = 0;
                for (int x=i;x<n;x+=j) {
                    if (str.charAt(x) == '*') {
                        k++;
                    } else {
                        break;
                    }
                }
                if (k >= 5) {
                    pw.println("yes");
                    return;
                }
            }
        }
        
        pw.println("no");
    }
}