import java.util.*;

public class A {

    public static void main(String[] args) {
        new A().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        char[] l = in.nextLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if (l[i] == '.') continue;
            for (int j = 1; j < n; j++) {
                if (i + j * 4 >= n) continue;
                boolean f = true;
                for (int k = 1; k <= 4; k++) {
                    if (l[i + j * k] == '.')
                        f = false;
                }
                if (f) { System.out.println("yes"); return; }
            }
        }
        System.out.println("no");
    }
}