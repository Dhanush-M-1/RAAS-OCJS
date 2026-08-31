import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dfs("a", 1, N);
    }

    private static void dfs(String w, int mx,  int N) {
        if (w.length() == N) {
            System.out.println(w);
            return;
        }

        for (int i = 0; i <= mx; i++) {
            StringBuilder builder = new StringBuilder(w);
            dfs(builder.append((char)('a'+i)).toString(), i+1 < mx ? mx : i+1, N);
        }
    }
}

