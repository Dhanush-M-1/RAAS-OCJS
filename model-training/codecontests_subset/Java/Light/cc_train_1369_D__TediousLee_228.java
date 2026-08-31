import java.util.*;
public class TediousLee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mod = 1000000007;
        int[] dpYes = new int[2000001];
        int[] dpNo = new int[2000001];
        dpYes[3] = 1;
        for (int i = 4; i <= 2000000; i++) {
            dpYes[i] = dpNo[i - 1] + dpNo[i - 2] * 2 % mod + 1;
            dpYes[i] %= mod;
            dpNo[i] = Math.max(dpNo[i - 1], dpYes[i - 1]) + Math.max(dpNo[i - 2], dpYes[i - 2]) * 2 % mod;
            dpNo[i] %= mod;
        }
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            System.out.println(Math.max(dpYes[n], dpNo[n]) * 2 % mod * 2 % mod);
        }
    }
}