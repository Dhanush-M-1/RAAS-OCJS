import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long mod = 1000000007L;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long[] S = new long[n + 1];
        S[0] = 1;
        S[1] = 1;
        for(int i = 0; i < m; i++) S[Integer.parseInt(sc.next())]--;
        for(int i = 2; i <= n; i++) {
            if(S[i] == -1) S[i] = 0;
            else S[i] = (S[i-1] + S[i-2]) % mod;
        }
        System.out.println(S[n]);
    }
}
