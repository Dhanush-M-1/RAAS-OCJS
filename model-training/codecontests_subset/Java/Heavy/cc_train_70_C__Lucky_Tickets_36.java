import java.io.IOException;
import java.util.*;

/**
 * Author: dened
 * Date: 26.03.11
 */
public class C {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int mx = in.nextInt();
        int my = in.nextInt();
        int w = in.nextInt();
        Map<Map.Entry<Integer, Integer>, List<Integer>> map = new HashMap<Map.Entry<Integer, Integer>, List<Integer>>();

        for (int a = 1; a <= Math.max(mx, my); ++a) {
            int b = rev(a);
            Map.Entry<Integer, Integer> key = getKey(b, a);
            List<Integer> list = map.get(key);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(key, list);
            }
            list.add(a);
        }

        int[] c = new int[Math.max(mx, my) + 1];
        int p = c.length - 1;
        long s = 0;
        long ans = Long.MAX_VALUE;
        int ansx = 0;
        int ansy = 0;
        for (int a = 1; a <= Math.min(mx, my); ++a) {
            List<Integer> list = map.get(getKey(a, rev(a)));
            if (list != null) {
                for (int b : list) {
                    if (b <= p) {
                        ++c[b];
                        ++s;
                        while (s - c[p] >= w) {
                            s -= c[p];
                            --p;
                        }
                    }
                }
            }
            if (s >= w && (long)a*p < ans) {
                ans = (long)a*p;
                ansx = a;
                ansy = p;
            }
        }
        if (ans != Long.MAX_VALUE) {
            if (ansx > mx || ansy > my) {
                System.out.println(ansy + " " + ansx);
            }
            else {
                System.out.println(ansx + " " + ansy);
            }
        }
        else {
            System.out.println(-1);
        }
    }

    private static Map.Entry<Integer, Integer> getKey(int a, int b) {
        int d = gcd(a, b);

        return new AbstractMap.SimpleEntry<Integer, Integer>(a / d, b / d);
    }

    private static int rev(int a) {
        int b = 0;
        int t = a;
        while (t > 0) {
            b *= 10;
            b += t % 10;
            t /= 10;
        }
        return b;
    }

    static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
