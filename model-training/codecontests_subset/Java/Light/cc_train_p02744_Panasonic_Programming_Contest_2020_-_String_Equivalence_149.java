import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        dfs(n, (char) ('a' - 1), new StringBuilder());
    }

    private static void dfs(int n, char max, StringBuilder s) {
        if (s.length() == n) {
            System.out.println(s.toString());
            return;
        }
        for (char c = 'a'; c <= max + 1; c++) {
            StringBuilder temp = new StringBuilder(s.toString());
            temp.append(c);
            dfs(n, (char) Math.max(c, max), temp);
        }
    }
}