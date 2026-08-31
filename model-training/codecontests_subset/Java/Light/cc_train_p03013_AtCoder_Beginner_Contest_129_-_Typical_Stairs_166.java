import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] ans = new long[n+1];
        ans[0] = 1;
        for (int i = 0; i < m; i++) {
            ans[sc.nextInt()] = -1;
        }
        if (ans[1] == -1) {
            ans[1] = 0;
        } else {
            ans[1] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            if(ans[i] == -1) {
                ans[i] = 0;
            } else {
                ans[i] = (ans[i-2] + ans[i-1]) % 1000000007;
            }
        }
        System.out.println(ans[n]);
    }

}
