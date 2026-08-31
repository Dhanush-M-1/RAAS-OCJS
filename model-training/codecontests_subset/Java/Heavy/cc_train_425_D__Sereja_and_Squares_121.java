import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    // final static int mod = 64;
    final static int N = 100005;
    final static int B = 350;
    BufferedReader in;

    void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        //Point pt = new Point(1, 1);
        HashSet<Long> hs = new HashSet<Long>();

        ArrayList<Integer>[] vec = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            vec[i] = new ArrayList<Integer>();
        }

        String str = in.readLine();
        int n = Integer.valueOf(str);

        // System.out.println(n);

        for (int i = 0; i < n; i++) {
            str = in.readLine();
            String[] tmp = str.split(" ");
            int x = Integer.valueOf(tmp[0]);
            int y = Integer.valueOf(tmp[1]);
            vec[x].add(y);
            hs.add((long)x * N + y);
        }

        long res = 0;

        for (int i = 0; i < N; i++) {
            if (vec[i].size() <= B)
                continue;
            for (Long v : hs) {
                int y = (int) (v % N);
                int x = (int) ((v - y) / N);
                if (x <= i)
                    continue;
                int d = Math.abs(x - i);
                
     
                if (hs.contains((long)i * N + y)
                        && hs.contains((long)i * N + y + d)
                        && hs.contains((long)x * N + y + d)) {
                    res++;
                }
            }
        }
        
        

        int[] tmp = new int[N];
        int tot = 0;

        for (int i = 0; i < N; i++) {
            if (vec[i].size() > B || vec[i].size() <= 1)
                continue;
            tmp[tot++] = i;
        }

        for (int i = 0; i < tot; i++) {

            int idx = tmp[i];
            
            for (int j = 0; j < vec[idx].size(); j++) {
                for (int k = j + 1; k < vec[idx].size(); k++) {
                    int ya = vec[idx].get(j);
                    int yb = vec[idx].get(k);
                    int d = Math.abs(yb - ya);
                    
                    long v1 = (long)(idx + d) * N + ya;
                    long v2 = (long)(idx + d) * N + yb;
                    
                    if (hs.contains(v1) && hs.contains(v2)) {
                        res++;
                    }
                }
            }

        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}