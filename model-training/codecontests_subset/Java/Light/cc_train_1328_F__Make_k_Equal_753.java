//Created by Aminul on 8/30/2019.

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class D {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int maxn = (int) 2e5;
        List<Integer> g[] = genList(maxn + 1);
        int n = in.nextInt(), k = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(), moves = 0;
            while (x >= 0) {
                g[x].add(moves);
                moves++;
                x /= 2;
                if (x == 0) break;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= maxn; i++) {
            if (g[i].size() < k) continue;
            Collections.sort(g[i]);
            int tmp = 0;
            for (int j = 0; j < k; j++) {
                tmp += g[i].get(j);
            }
            min = min(min, tmp);
        }
        pw.println(min);
        pw.close();
    }

    static <T> List<T>[] genList(int n) {
        List<T> list[] = new List[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<T>();
        return list;
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}