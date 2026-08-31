import java.util.*;

class Main {
    public static void main(String[] args) {
        new Solver().run();
    }
}

class Solver {
    private String MATCH = "keyence";

    public void run() {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int N = MATCH.length();

        for (int i = 0; i < N; i++) {
            String pre = MATCH.substring(0, i);
            String suf = MATCH.substring(i, N);

            if (S.startsWith(pre) && S.endsWith(suf)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
        return;
    }

}