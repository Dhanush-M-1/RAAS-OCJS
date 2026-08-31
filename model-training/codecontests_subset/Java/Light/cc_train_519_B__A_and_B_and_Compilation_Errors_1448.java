import java.util.*;


public class B519 {
    private static long getSum(Scanner sc, int n) {
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += sc.nextLong();
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0, sum1 = 0, sum2 = 0;
        sum = getSum(sc, n);
        sum1 = getSum(sc, n-1);
        sum2 = getSum(sc, n-2);
        sc.close();
        System.out.println((sum-sum1) + "\n" + (sum1 - sum2));
    }
}