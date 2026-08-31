import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;



public class Main {
    static int mod = (int)1e9+7;
    static int inf = (int)(2e9+1e8);
    static long INF = (long)(2e16);
    static double eps = 1e-9;
    static double PI = Math.acos(-1.0);
    static int N = (int)2e5 + 10;
    long[] a = new long[N], b = new long[N], c = new long[N];
    TreeSet<Long> s = new TreeSet();
    int upper_bound(long[] x, int l, int r, long val) {
        int pos = r;
        r --;
        while(l <= r) {
            int mid = (l+r)/2;
            if(x[mid] <= val) {
                l = mid+1;
            } else {
                pos = mid;
                r = mid-1;
            }
        }
        return pos;
    }
    
    void work() {
        int n = cin.nextInt();
        int sum = 0, cnt = 0;
        for(int i = 1, x; i <= n; i ++) {
            x = cin.nextInt();
            sum += x;
            if(x == 100) cnt ++;
        }
        if(sum % 200 != 0) {
            out.println("NO");
        } else {
            if(cnt == 0 && sum%400 != 0) 
                out.println("NO");
            else 
                out.println("YES");
        }

        out.close();
    }
    Main() {
        out = new PrintWriter(System.out);
        cin = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main wo = new Main();
        wo.work();
    }
    DecimalFormat df=new DecimalFormat("0.000000");
    public Scanner cin;
    public PrintWriter out;
}