
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by mostafa on 9/16/17.
 */
public class FoxJumps {
    static class State implements Comparable<State>{
        int i, gcd;
        State(int i, int gcd) {
            this.i = i; this.gcd = gcd;
        }

        @Override
        public int compareTo(State s) {
            if(i == s.i)
                return gcd - s.gcd;
            return i - s.i;
        }
    }
    static int gcd(int a, int b) {
        if(b == -1)
            return a;
        if(a == -1)
            return b;
        return b == 0 ? a : gcd(b, a % b);
    }

    static int n;
    static int[] c, l;
    static TreeMap<State, Integer> dp = new TreeMap();
    static int solve(int i, int gcd) {
        if(i == n)
            return gcd == 1 ? 0 : (int) 1e8;

        State cur = new State(i, gcd);
        if(dp.containsKey(cur))
            return dp.get(cur);

        int ans = Math.min(c[i] + solve(i + 1, gcd(gcd, l[i])), solve(i + 1, gcd));
        dp.put(cur, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = new int[n]; l = new int[n];
        for(int i = 0; i < n; i++)
            l[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            c[i] = sc.nextInt();

        int ans = solve(0, -1);
        if(ans >= (int) 1e8)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
