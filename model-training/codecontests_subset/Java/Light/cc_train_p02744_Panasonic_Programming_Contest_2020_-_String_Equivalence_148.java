import java.util.*;

public class Main {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    char max = 'a';

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {

        dfs("a");
    }

    void dfs(String s) {
        if (s.length() == n) {
            System.out.println(s);
        } else {
            if (s.charAt(s.length()-1) > max) {
                max = s.charAt(s.length()-1);
                char tmp = max;
                tmp += 1;
                for (char c='a'; c<=tmp; c++) {
                    dfs(s + c);
                }
                --max;
            } else {
                char tmp = max;
                tmp += 1;
                for (char c='a'; c<=tmp; c++) {
                    dfs(s + c);
                }
            }
        }
    }
}