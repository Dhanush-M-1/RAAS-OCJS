import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author thachlp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer arr[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = n;
        Arrays.sort(arr);

        int l = 0;
        int r = 1;
        while (r < n) {
            if (arr[r] > arr[l] && arr[r] <= k + arr[l] ) {
                result--;
                l++;
            } else if (arr[r] - arr[l] > k) {
                l++;
            } else {
                r++;
            }
        }
        System.out.println(result);
    }
}