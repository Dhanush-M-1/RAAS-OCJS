import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int ans = 0;
        boolean flg = false;
        for (int i = 1; i <= n; i++) {
            if(i < n && p[i + 1] == i + 1 && p[i] == i) {
                ans++;
                i++;
            } else if(p[i] == i) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
