import java.io.*;
import java.util.*;

public class Solution {

    final static long limit = (long) 1e9;
    static Set<Long> mark;
    static Map<Long, Integer> dist;
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    static long x0, y0, x1, y1;
	static int n;
    public static void main(String[] args) {
        mark = new HashSet<Long>();
        dist = new HashMap<Long, Integer>();
        Scanner sc = new Scanner(System.in);
        x0 = sc.nextInt();
        y0 = sc.nextInt();
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        mark.add(calc(x0, y0));
        mark.add(calc(x1, y1));

        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            long r, a, b;
            r = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            for (long j = a; j <= b; j++) {
                mark.add(calc(r, j));
            }
        }
        bfs();
    }

    public static long calc(long x, long y) {
        long val = x;
        val = val * limit + y;
        return val;
    }

    public static void bfs() {
        Queue<Long> myqueue =  new LinkedList<Long>();
        long S = calc(x0, y0);
        myqueue.offer(S);
        dist.put(S, 0);

        while (myqueue.size() > 0) {
            long u = myqueue.peek();
            myqueue.poll();
            long x = u / limit;
            long y = u % limit;
            for (int i = 0; i < 8; i++) {
                long xx = x + dx[i];
                long yy = y + dy[i];
                long v = calc(xx, yy);
                if (xx >= 1 && xx <= limit && yy >= 1 && yy <= limit && 
                        mark.contains(v)) {
                            if (!dist.containsKey(v)) {
                                dist.put(v, dist.get(u)+1);
                                if (v == calc(x1, y1)) {
                                    System.out.print(dist.get(v));
                                    return;
                                }
                                myqueue.offer(v);
                            }
                        }
            }
        }

        System.out.print("-1");
    }


}
