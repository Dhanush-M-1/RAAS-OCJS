import java.util.*;

class Main {

    static void swapRange(int b, int e, int t, int[] arr) {
        for (int k = 0; k < e - b; k ++) {
            int tmp = arr[b + k];
            arr[b + k] = arr[t + k];
            arr[t + k] = tmp;
        }
    }

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i ++) {
            arr[i] = input.nextInt();
        }

        int q = input.nextInt();
        for (int count = 0; count < q; count++) {
            int b = input.nextInt();
            int e = input.nextInt();
            int t = input.nextInt();
            swapRange(b, e, t, arr);
        }

        for (int i = 0; i < n - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[n-1]);
    }
}
