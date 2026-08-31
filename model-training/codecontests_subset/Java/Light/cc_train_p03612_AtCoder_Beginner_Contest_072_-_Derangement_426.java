import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == i + 1) {
                if (i == n - 1) {
                    int t = p[i];
                    p[i] = p[i - 1];
                    p[i - 1] = t;
                } else {
                    int t = p[i];
                    p[i] = p[i + 1];
                    p[i + 1] = t;
                }
                ans++;
            }
        }
        System.out.println(ans);
    }
}