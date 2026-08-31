import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class CF290B {

    static int[] l;
    static int[] c;
    static TreeMap<Integer, Integer> dp = new TreeMap<Integer, Integer>();

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int f(int g) {
        if (g == 1)
            return 0;
        if (dp.containsKey(g))
            return dp.get(g);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++)
            if (gcd(l[i], g) != g)
                answer = Math.min(answer, f(gcd(l[i], g)) + c[i]);
        dp.put(g, answer);
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        l = new int[n];
        c = new int[n];
        int g = 0;
        for (int i = 0; i < n; i++) {
            l[i] = in.nextInt();
            g = gcd(l[i], g);
        }
        if (g != 1) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < n; i++)
            c[i] = in.nextInt();
        System.out.println(f(0));
    }
}
