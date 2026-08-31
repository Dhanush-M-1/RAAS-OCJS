import java.util.*;

public class FoxDividingCheese {
    
    static int[] factor(int x) {
        int[] factorCount = new int[4]; // 2, 3, 5, rest
        int[] factors = {2, 3, 5};
        for (int i = 0; i < factors.length; i++) {
            while (x % factors[i] == 0) {
                factorCount[i]++;
                x /= factors[i];
            }
        }
        factorCount[factorCount.length - 1] = x;
        return factorCount;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        
        int[] factorCountA = factor(a);
        int[] factorCountB = factor(b);
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += Math.abs(factorCountA[i] - factorCountB[i]);
        }
        System.out.println(factorCountA[3] == factorCountB[3] ? ans : -1);
        
        in.close();
        System.exit(0);
    }
}
