
import java.util.Scanner;

/**
 * May 5, 2016 | 5:01:44 PM
 * <pre>
 * <u>Description</u>
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 */
public class ProblemB{
    
    int search(int k){
        int left = 0;
        int right = 100000;
        while (right - left > 1) {
            int mid = left + right >> 1;
            if (1L * mid * (mid + 1) / 2 >= k)
                right = mid;
            else
                left = mid;
        }
        return left;
    }
    
    int solve(int k, int[] ids) {
        int p = search(k);
        int sum = k - (int)(1L * p * (p + 1) / 2);
        return ids[sum - 1];
    }
    
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ids = new int[n];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = sc.nextInt();
            }
            System.out.println(new ProblemB().solve(k, ids));
        }
    }
}
