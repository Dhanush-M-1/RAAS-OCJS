import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        int votes = max * n - sum;
        while (votes <= sum) {
            max++;
            votes = max * n - sum;
        }
        System.out.println(max);
    }
}