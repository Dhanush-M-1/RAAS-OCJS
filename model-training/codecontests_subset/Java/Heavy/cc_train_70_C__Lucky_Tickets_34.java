
import java.util.HashMap;
import java.util.Scanner;

public class C {
    public static long gcd(long x, long y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    public static long getHash(long x, long y) {
        return x * 1000000 + y;
    }

    public static int get(HashMap<Long, Integer> H, long x) {
        if (H.containsKey(x))
            return H.get(x);
        else
            return 0;
    }

    public static void add(HashMap<Long, Integer> H, long x, int v) {
        if (H.containsKey(x))
            H.put(x, H.get(x) + v);
        else
            H.put(x, v);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxX = in.nextInt();
        int maxY = in.nextInt();
        long w = in.nextLong();
        long HX[] = new long[Math.max(maxX, maxY) + 1];
        long HY[] = new long[Math.max(maxX, maxY) + 1];
        for (int i = 1; i <= Math.max(maxX, maxY); i++) {
            int rev = Integer.parseInt(new StringBuffer("" + i).reverse()
                    .toString());
            long gcd = gcd(i, rev);
            long hash = getHash(i / gcd, rev / gcd);
            HX[i] = hash;
            hash = getHash(rev / gcd, i / gcd);
            HY[i] = hash;
        }
        HashMap<Long, Integer> H1 = new HashMap<Long, Integer>();
        for (int i = 1; i <= maxX; i++)
            add(H1, HX[i], 1);
        HashMap<Long, Integer> H2 = new HashMap<Long, Integer>();
        long sum = 0;
        int y = 0;
        long ansX = (long) 1e9;
        long ansY = (long) 1e9;
        for (int i = maxX; i > 0; i--) {
            if (sum >= w) {
                if ((long) i * (long) y < ansX * ansY) {
                    ansX = i;
                    ansY = y;
                }
            } else
                while (y < maxY) {
                    y++;
                    add(H2, HY[y], 1);
                    sum += get(H1, HY[y]);
                    if (sum >= w) {
                        if ((long) i * (long) y < ansX * ansY) {
                            ansX = i;
                            ansY = y;
                        }
                        break;
                    }
                }
            sum -= get(H2, HX[i]);
            add(H1, HX[i], -1);
        }
        if (ansX == 1e9)
            System.out.println(-1);
        else
            System.out.println(ansX + " " + ansY);
    }
}
