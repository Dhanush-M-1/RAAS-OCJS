import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class C {
    private static int reverse(int n) {
        int res = 0;
        int temp = n;
        while (temp > 0) {
            res = 10 * res + temp % 10;
            temp /= 10;
        }
        return res;
    }
    
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    private static int[] nom;
    private static int[] den;
    
    public class Pair implements Comparable<Pair> {
        public int num;
        public int first;
        public int second;
        public Pair(int n, int f, int s) {
            num = n;
            first = f;
            second = s;
        }
        @Override
        public int compareTo(Pair other) {
            if (second == other.second) {
                return num - other.num;
            }
            return second - other.second;
        }
    }
    
    private static C temp;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int maxser = in.nextInt();
        int maxtic = in.nextInt();
        int lucky = in.nextInt();
        int[] rev = new int[Math.max(maxser, maxtic) + 1];
        for (int i = 0; i <= Math.max(maxser, maxtic); ++i) {
            rev[i] = reverse(i);
        }
        nom = new int[Math.max(maxser, maxtic) + 1];
        den = new int[Math.max(maxser, maxtic) + 1];
        // a / rev(a)
        for (int i = 1; i <= Math.max(maxser, maxtic); ++i) {
            int del = gcd(i, rev[i]);
            nom[i] = i / del;
            den[i] = rev[i] / del;
        }
        HashMap<Long, ArrayList<Integer>> pairs = new HashMap<Long, ArrayList<Integer>>();
        for (int i = 1; i <= maxtic; ++i) {
            long cur = 100001L * den[i] + nom[i];
            if (!pairs.containsKey(cur)) {
                pairs.put(cur, new ArrayList<Integer>());
            }
            pairs.get(cur).add(i);
        }
        TreeSet<Pair> already = new TreeSet<Pair>();
        int curtic = 0;
        temp = new C();
        int minser = -1;
        int bestser = -1;
        long pro = Long.MAX_VALUE;
        int tic = 0;
        for (int i = 1; i <= maxser; ++i) {
            long cur = 100001L * nom[i] + den[i];
            if (!pairs.containsKey(cur)) {
                continue;
            }
            for (int j: pairs.get(cur)) {
                already.add(temp.new Pair(curtic++, i, j));             
            }
            for (Iterator<Pair> it = already.descendingIterator(); it.hasNext();) {
                if (curtic <= lucky) {
                    break;
                }
                curtic--;
                it.next();
                it.remove();
            }
            if (curtic == lucky) {
                bestser = i;
                pro = 1L * i * already.last().second;
                tic = already.last().second;
                minser = i;
                break;
            }
        }
        if (curtic < lucky) {
            out.println(-1);
        } else {
            for (int i = minser + 1; i <= maxser; ++i) {
                long cur = 100001L * nom[i] + den[i];
                if (!pairs.containsKey(cur)) {
                    continue;
                }
                for (int j: pairs.get(cur)) {
                    already.add(temp.new Pair(curtic++, i, j));
                }
                for (Iterator<Pair> it = already.descendingIterator(); it.hasNext();) {
                    if (already.size() == lucky) {
                        break;
                    }
                    it.next();
                    it.remove();
                }
                long curpro = 1L * i * already.last().second;
                if (curpro < pro) {
                    pro = curpro;
                    bestser = i;
                    tic = already.last().second;
                }
            }
            out.println(bestser + " " + tic);
        }
        in.close();
        out.close();
    }
}
