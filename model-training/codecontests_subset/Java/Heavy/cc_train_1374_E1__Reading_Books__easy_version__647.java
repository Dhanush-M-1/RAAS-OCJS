//Created by Aminul on 6/28/2020.

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class E1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt(), k = in.nextInt();
        PriorityQueue<Integer> aliceLikes = new PriorityQueue<>();
        PriorityQueue<Integer> bobLikes = new PriorityQueue<>();
        PriorityQueue<Integer> bothLike = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int t = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            if (a == 1 && b == 1) {
                bothLike.add(t);
            } else if (a == 1) {
                aliceLikes.add(t);
            } else if (b == 1) {
                bobLikes.add(t);
            }
        }

        int inf = (int) 1e9;
        long res = 0;
        int cntAlice = 0, cntBob = 0;
        
        while (cntAlice < k || cntBob < k) {
            int a = inf, b = inf, c = inf;
            if (!aliceLikes.isEmpty()) a = aliceLikes.peek();
            if (!bobLikes.isEmpty()) b = bobLikes.peek();
            if (!bothLike.isEmpty()) c = bothLike.peek();

            if (cntAlice < k && cntAlice < k) {
                if (a + b <= c && a + b < inf) {
                    res += (a + b);
                    aliceLikes.poll();
                    bobLikes.poll();
                    cntAlice++;
                    cntBob++;
                } else if (c <= a + b && c < inf) {
                    res += c;
                    bothLike.poll();
                    cntAlice++;
                    cntBob++;
                } else {
                    res = -1;
                    break;
                }
            } else if (cntAlice < k) {
                if (a <= c && a < inf) {
                    res += a;
                    aliceLikes.poll();
                    cntAlice++;
                } else if (c <= a && c < inf) {
                    res += c;
                    bothLike.poll();
                    cntAlice++;
                    cntBob++;
                } else {
                    res = -1;
                    break;
                }
            } else if (cntBob < k) {
                if (b <= c && b < inf) {
                    res += b;
                    bobLikes.poll();
                    cntBob++;
                } else if (c <= b && c < inf) {
                    res += c;
                    bothLike.poll();
                    cntAlice++;
                    cntBob++;
                } else {
                    res = -1;
                    break;
                }
            }
        }

        pw.println(res);

        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}