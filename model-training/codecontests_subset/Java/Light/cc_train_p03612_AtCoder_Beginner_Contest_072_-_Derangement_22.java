import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p[] = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt() - 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == i) {
                ans++;
                i++;
            }
        }

        System.out.println(ans);
    }
}