import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by artur on 11/30/16.
 */
public class B {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[11];
        Arrays.fill(arr, 0);

        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            arr[val]++;
        }
        long answer = 0;
        for (int i = 1; i <= 10; i++) {
            int rep = 0;
            for (int j = i + 1; j <= 10; j++) {
                rep += arr[j];
            }
            answer += rep * arr[i];
        }

        System.out.println(answer);
    }


}
