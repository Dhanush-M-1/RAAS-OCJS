import java.util.*;
import java.lang.Math;
public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int v5n = 0;
        int v5k = 0;
        int v3n = 0;
        int v3k = 0;
        int v2n = 0;
        int v2k = 0;
        while(n % 5 == 0) {
            n /= 5;
            v5n++;
        }
        while(n % 3 == 0) {
            n /= 3;
            v3n++;
        }
        while(n % 2 == 0) {
            n /= 2;
            v2n++;
        }
        while(k % 5 == 0) {
            k /= 5;
            v5k++;
        }
        while(k % 3 == 0) {
            k /= 3;
            v3k++;
        }
        while(k % 2 == 0) {
            k /= 2;
            v2k++;
        }
        if(k != n)
            System.out.println("-1");
        else {
            int ans = Math.abs(v5n - v5k) + Math.abs(v3n - v3k) + Math.abs(v2n - v2k);
            System.out.println(ans);
        }
    }
}
