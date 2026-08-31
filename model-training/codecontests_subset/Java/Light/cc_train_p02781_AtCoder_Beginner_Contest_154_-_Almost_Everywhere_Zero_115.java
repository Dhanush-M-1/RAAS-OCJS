import java.util.*;

public class Main {

    private static char[] N;
    private static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.next().toCharArray();
        K = sc.nextInt();
        int ans = dfs(0,true,0);
        System.out.println(ans);
    }

    private static int dfs(int pos, boolean same, int k) {
        if (k == K) {
            return 1;
        }
        if (pos == N.length) {
            return 0;
        }

        int ret = 0;
        int last = same ? N[pos]-'0' : 9;
        for (int i = 0; i <= last; i++) {
            int nextK = i == 0 ? k : k+1;
            boolean nextSame = same && i == last;
            ret += dfs(pos+1, nextSame, nextK);
        }
        return ret;
    }
}

