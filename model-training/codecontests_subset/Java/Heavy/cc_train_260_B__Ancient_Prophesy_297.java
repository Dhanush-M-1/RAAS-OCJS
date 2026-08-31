
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private void run() {
            
            try {
               String input = in.readLine();
               s = input.toCharArray();
            } catch (IOException ex) {
                throw new RuntimeException("input");
            }
            int l = -1;
            for (int r = 1; r < s.length; r++) {
                if (s[r] == '-') {
                    if (r - l == 3 && l >= 2 && r + 4 < s.length) {
                        check(l - 2, r + 4);
                    }
                    l = r;
                }
            }
            Iterator it = map.entrySet().iterator();
            String ans = "$";
            int max = 0;
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                Integer val = (Integer) pairs.getValue();
                if (val > max) {
                    max = val;
                    ans = (String) pairs.getKey();
                }
            }
            out.println(ans);
            
            out.close();
    }

    public static void main(String[] args) {
        new Main().run();
    }
        char s[];
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    private void check(int l, int r) {
//        System.out.println(l + " " + r);
        int d = 0, m = 0, y = 0;
        String x = "";
        for (int j = l; j <= r; j++) {
            x += s[j];
            if (j != l + 2 && j != r - 4) {
                if (s[j] < '0' || s[j] > '9') return;
                if (j < l + 2) {
                    d = d * 10 + s[j] - '0';
                } else if (j < r - 4) {
                    m = m * 10 + s[j] - '0';
                } else
                    y = y * 10 + s[j] - '0';
            }
        }
//        System.out.println(d + " " + m + " " + y);
        if (m < 1 || m > 12) return;
        if (y < 2013 || y > 2015) return;
        if (d < 1 || d > days[m - 1]) return;
        Integer v = map.get(x);
        Integer nv = 1;
        if (v != null) 
            nv = v + 1;
        map.put(x, nv);
    }
    int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
}
