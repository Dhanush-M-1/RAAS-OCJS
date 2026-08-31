
/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Not sended
 * @url <https://codeforces.com/problemset/problem/CF1369D>
 * @category ?
 * @date 23/06/2020
 **/

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class CF1369D {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.fill(mem, -1);
        for (int i = 0; i < mem.length; i++)
            f(i);
        for (int t = 0; t < T; t++) {
            int N = parseInt(in.readLine());
            sb.append((4 * f(N)) % MOD).append("\n");
        }
        System.out.print(new String(sb));
    }

    static long[] mem = new long[2000001];
    static long MOD = 1000000007;

    static long f(int p) {
        if (p < 3) return 0;
        if (mem[p] >= 0)
            return mem[p];
        if (p % 3 == 0)
            return mem[p] = (4 * f(p - 4) + 4 * f(p - 3) + f(p - 2) + 1) % MOD;
        return mem[p] = (2 * f(p - 2) + f(p - 1)) % MOD;
    }
}
