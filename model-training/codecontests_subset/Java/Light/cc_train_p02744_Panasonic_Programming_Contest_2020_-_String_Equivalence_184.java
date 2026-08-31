import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dfs("", 'a');
    }

    public static void dfs(String s, char mx) {
        if (s.length() == n) {
            System.out.println(s);
        } else {
            for (char c = 'a'; c <= mx; c++) {
                dfs(s + c, ((c == mx) ? (char)(mx + 1) : mx));
            }
        }
    }
}