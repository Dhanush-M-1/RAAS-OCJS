import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            int th = sc.nextInt();
            int ans = 0;
            while (s >= 1 && th >= 2) {
                s -= 1;
                th -= 2;
                ans += 3;
            }
            while (f >= 1 && s >= 2) {
                f -= 1;
                s -= 2;
                ans += 3;
            }
            System.out.println(ans);
        }
    }
}