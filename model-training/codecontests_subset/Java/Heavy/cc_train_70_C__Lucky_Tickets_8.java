import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C70 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int X = in.nextInt(), Y = in.nextInt();
        int w = in.nextInt();
        int ansX = Integer.MAX_VALUE, ansY = Integer.MAX_VALUE;
        
        for (int i = 1; i <= Y; i++) if (i%10 != 0) {
            int r = rev(i);
            int g = gcd(i, r);
            long k = 1L*(i/g)*(MAX+1) + (r/g);
            if (!h.containsKey(k))
                h.put(k, new ArrayList<Integer>());
            h.get(k).add(i);
        }
        
        M = Y;
        t = new int[Y+1];
        int sum = 0;

        for (int i = 1; i <= X; i++) if (i%10 != 0) {
            int r = rev(i);
            int g = gcd(i, r);
            long k = 1L*(r/g)*(MAX+1) + (i/g);
            if (h.containsKey(k))
                for (int y : h.get(k)) {
                    modify(y, 1);
                    sum++;
                }
            
            if (sum < w) continue;
            
            int lo = 1, hi = Y;
            while (hi - lo > 0) {
                int cur = (lo + hi)/2;
                int s = get(cur);
                if (s >= w) hi = cur;
                else lo = cur+1;
            }
            
            if (1L*i*lo < 1L*ansX*ansY) {
                ansX = i;
                ansY = lo;
            }
        }
        
        if (ansX == Integer.MAX_VALUE) out.println("-1");
        else out.println(ansX + " " + ansY);
        
        out.flush();
    }
    
    static Map<Long, List<Integer>> h = new HashMap<Long, List<Integer>>();
    
    static int MAX = 100000;
    static int[] rev = new int[MAX+1];
    static {
        Arrays.fill(rev, -1);
    }
    
    static int M;
    static int[] t;

    static void modify(int x, int v) {
        t[x] += v;
        while ((x += x&(-x)) <= M) t[x] += v;
    }
    
    static int get(int x) {
        int res = t[x];
        while ((x -= x&(-x)) >= 1) res += t[x];
        return res;
    }

    static int rev(int x) {
        if (rev[x] != -1) return rev[x];
        StringBuilder X = new StringBuilder(x+"");
        return rev[x] = Integer.valueOf(X.reverse().toString());
    }
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
