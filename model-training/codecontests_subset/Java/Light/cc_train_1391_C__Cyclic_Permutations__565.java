import java.util.Scanner;

public class C1391 {

    public static void main(String[] args) {
        long mod = 1000000007;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long fact = 1;
        long pow = 1;
        for (int n=2; n<=N; n++) {
            fact *= n;
            pow *= 2;
            fact %= mod;
            pow %= mod;
        }
        long result = (fact + mod - pow)%mod;
        System.out.println(result);
    }

}
