
import java.util.Scanner;

/**
 *
 * @author msagimbekov
 */
public class Codeforces915A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int v = x[i];
            if (k % v == 0) {
                min = Math.min(min, k / v);
            }
        }
        
        System.out.println(min);
    }
}
