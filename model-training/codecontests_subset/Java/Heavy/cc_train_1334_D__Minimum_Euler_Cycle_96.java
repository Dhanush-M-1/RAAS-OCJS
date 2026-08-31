import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.math.*;

public class Main { 
    
    static boolean FROM_FILE = false;
    
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader() { 
            if (FROM_FILE) {
                try {
                    br = new BufferedReader(new FileReader("input.txt")); 
                } catch (IOException error) {
                }   
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));    
            }
        }
        String next() { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } catch (IOException  e) { 
                    e.printStackTrace(); 
                } 
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
        String nextLine() { 
            String str = ""; 
            try { 
                str = br.readLine(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    static int max(int... nums) {
        int res = Integer.MIN_VALUE;
        for (int num: nums) res = Math.max(res, num);
        return res;
    }
    static int min(int... nums) {
        int res = Integer.MAX_VALUE;
        for (int num: nums) res = Math.min(res, num);
        return res;
    }
    static long max(long... nums) {
        long res = Long.MIN_VALUE;
        for (long num: nums) res = Math.max(res, num);
        return res;
    }
    static long min(long... nums) {
        long res = Long.MAX_VALUE;
        for (long num: nums) res = Math.min(res, num);
        return res;
    }
    
    static FastReader fr = new FastReader();
    static PrintWriter out;
    
    public static void main(String[] args) { 
        if (FROM_FILE) {
            try {
                out = new PrintWriter(new FileWriter("output.txt"));
            } catch (IOException error) {
                
            }
        } else {
            out = new PrintWriter(new OutputStreamWriter(System.out));
        }
        new Main().run();
        out.flush();
        out.close();
    } 
    
    long getLevel(long n, long idx) {
        for (long i = 1; i <= n; i += 1) {
            if ((2 * n - 1 - i) * i >= idx) return i;
        }
        return -1;
    }
    
    void run() {
        int t = fr.nextInt();
        while (t-- > 0) {
            long n = fr.nextLong(), l = fr.nextLong(), r = fr.nextLong();
            if (l == n * (n - 1) + 1) {
                out.println(1);
                continue;
            }
            int len = (int)(r - l) + 1;
            long[] res = new long[len];
            int idx = 0;
            long k = getLevel(n, l), pre = (2 * n - 1 - (k - 1)) * (k - 1), col = k + (l - pre) / 2;
            if ((l - pre) % 2 == 0) res[idx++] = col;
            // out.println(col);
            for (long i = col + 1; i <= n && idx + 1 < len; i += 1) { res[idx++] = k; res[idx++] = i; }
            // out.println(Arrays.toString(res));
            boolean finalOne = false;
            if (r == n * (n - 1) + 1) {
                r -= 1;
                finalOne = true;
            }
            long k2 = getLevel(n, r);
            // out.println(k + " " + k2);
            for (long level = k + 1; level < k2; level += 1) {
                for (long i = level + 1; i <= n; i += 1) { res[idx++] = level; res[idx++] = i; }
            }
            // out.println(Arrays.toString(res));
            long last_x = k2, last_y = last_x + 1;
            while (idx + 1 < len) {
                res[idx++] = last_x;
                res[idx++] = last_y++;
            }
            if (idx < len) {
                res[idx] = finalOne ? 1 : last_x;
            }
            out.println(LongStream.of(res).mapToObj(e -> "" + e).collect(Collectors.joining(" ")));
            
        }
    }
}