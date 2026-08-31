import java.util.Scanner;

public class Main {

    private static int n;

    private static void dfs(String s, char mx) {
        if (s.length() == n) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i <= mx - 'a'; i++) {
            if (i == mx - 'a') {
                dfs(s + (char) (i + 'a'), (char) (mx + 1));
            } else {
                dfs(s + (char) (i + 'a'), mx);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs("", 'a');
    }

}
