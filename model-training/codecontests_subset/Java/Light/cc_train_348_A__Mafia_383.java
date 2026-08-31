import java.lang.*;
import java.util.*;

public final class Solution {
    public static void main(String[] args) {
        Solution program = new Solution();
        program.run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long sum = 0;
        long max = 0;
        long d = 0;
        for (int i = 0; i < n; i++) {
            d = sc.nextLong();
            sum = sum + d;
            max = Math.max(max, d);
        }
        n--;
        
        if (sum%n == 0) {
            System.out.println(Math.max(max,sum/n));
        } else {
            System.out.println(Math.max(max, sum/n + 1));
        }
        
    }
}