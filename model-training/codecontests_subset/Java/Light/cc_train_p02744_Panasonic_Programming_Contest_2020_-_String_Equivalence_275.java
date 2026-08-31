import java.util.*;

public class Main {

    static int n;
    static String[] S = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String s = "";
        sb = new StringBuilder();
        dfs(s, 1, 0);
        System.out.println(sb.toString());
        sc.close();

    }

    private static void dfs(String s, int i, int max) {
        for (int j = 0; j <  i; j++) {
            if(max < j) break;
            String a = s + S[j];
            if(i == n) System.out.println(a);
            else dfs(a, i+1, Math.max(j+1, max));
        }
    }

}
