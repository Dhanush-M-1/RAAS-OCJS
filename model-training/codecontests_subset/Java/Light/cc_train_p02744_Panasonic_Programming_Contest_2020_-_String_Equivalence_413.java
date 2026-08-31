import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static final int MOD = 1000000007;
    static final int INF = 1 << 30;
    int N;
    ArrayList<String> ans = new ArrayList<String>();

    Main() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // int[][] dp = new dp[N][N];
        // for(int i=0;)
        solve("a", 'a');
        Collections.sort(ans);
        PrintWriter pw = new PrintWriter(System.out);
        for (String str : ans)
            pw.println(str);
        pw.flush();
    }

    void solve(String s, char max) {
        if (s.length() == N) {
            ans.add(s);
            return;
        }
        char c = s.charAt(s.length() - 1);
        for (char i = 'a'; i <= max + 1; i++) {
            solve(s + i, i<max?max:i);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
