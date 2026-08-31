import java.util.Scanner;


public class C_LCM_Challenge {
    public static void main(String[] args) {
        int n  = new Scanner(System.in).nextInt();
        if (n == 1){
            System.out.println(1);
            return;
        }
        if (n == 2){
            System.out.println(2);
            return;
        }
        if (n == 3){
            System.out.println(6);
            return;
        }
        if (n == 4){
            System.out.println(12);
            return;
        }
        if (n == 5){
            System.out.println(60);
            return;
        }
        long ans = 0;
        for (int i = n-5; i <=n; i++) {
            for (int j = i+1; j <=n; j++) {
                for (int j2 = j+1; j2 <= n; j2++) {
                    ans = Math.max(ans, lcm(lcm(i,j2),j));
                }
            }
        }
        System.out.print(ans);
    }

    private static long lcm(long a, long b) {
        return a*b/gcd(a,b);
    }
    private static long gcd(long a, long b) {
        return (b ==0)?a:gcd(b,a%b);
    }

}
