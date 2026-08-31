
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_Garden {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        String[] nBuckets = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];

//        int n = 6;
//        int k = 7;
//        String[] nBuckets = {"1", "2", "3", "4", "5", "6", "7"};
//        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nBuckets[i]);
        }

        Arrays.sort(arr);
        for (int i = n - 1; i > -1; i--) {
            if (k >= arr[i] && k % arr[i] == 0) {
                System.out.println(k / arr[i]);
                return;
            }
        }

        return;
    }
}
