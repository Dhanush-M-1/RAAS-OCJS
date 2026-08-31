import java.util.*;
public class Problem1512G {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[10000009];
        long[] arr2 = new long[10000009];
        arr[1] = 1;
        for (int i = 2; i < 10000002; i++) {
            for (int j = i; j < 10000002; j = j + i) {
                arr2[j] += i;
            }
            if (arr2[i] <= 10000000 && arr[(int) arr2[i] + 1] == 0) {
                arr[(int) arr2[i] + 1] = i;
            }
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            if(arr[n] == 0) {
                System.out.println(-1);
            }
            else {
                System.out.println(arr[n]);
            }
        }
    }
}