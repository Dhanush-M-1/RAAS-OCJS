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
    
    int minimumTime(int[] dist, int tank) {
        int res = 0;
        for (int d : dist) {
            if (d > tank) return Integer.MAX_VALUE;
            if (d * 2 <= tank) res += d;
            else {
                double rate = 1 - (1.0 * tank / d - 1);
                int t = (int)Math.ceil(d * (1 + rate));
                res += t;
            }
        }
        return res;
    }
    
    void run() {
        int n = fr.nextInt(), k = fr.nextInt(), s = fr.nextInt(), t = fr.nextInt();
        if (s > t) {
            out.println(-1);
            return;
        }
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i += 1){
            cars[i][0] = fr.nextInt();
            cars[i][1] = fr.nextInt();
        }
        int[] gas = new int[k + 1];
        for (int i = 1; i <= k; i += 1) {
            gas[i] = fr.nextInt();
        }
        Arrays.sort(gas);
        int[] dist = new int[k + 1];
        for (int i = 0; i < k; i += 1) {
            dist[i] = gas[i + 1] - gas[i];
        }
        dist[k] = s - gas[k];
        // out.println(Arrays.toString(dist));
        // out.println(minimumTime(dist, 8) + " " + t);
        
        // binary search on tank size
        int lo = 1, hi = max(dist) * 2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int time = minimumTime(dist, mid);
            if (time > t) lo = mid + 1;
            else hi = mid;
        }
        int res = -1;
        for (int i = 0; i < n; i += 1) {
            if (cars[i][1] >= lo) {
                if (res == -1 || res > cars[i][0]) res = cars[i][0];
            } 
        }
        out.println(res);
    }
}