
import java.util.Scanner;

/**
 * Created by baturayk on 25/01/16.
 */
public class CF_609_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m, ans = 0;
        n = in.nextInt(); m = in.nextInt();
        int[] genreCounts = new int[m];
        for (int i = 0; i < n; i++) {
            int b = in.nextInt();
            genreCounts[b-1]++;
        }
        for (int i = 0; i < m-1; i++) {
            int sum = 0;
            for (int j = i+1; j < m; j++) {
                sum += genreCounts[j];
            }
            ans+= genreCounts[i]*sum;
        }
        System.out.println(ans);
    }
}
