import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        int[] arr = new int[n];
        int[] dpArr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = arr[i] + temp;
            if (arr[i] == 0) {
                if (temp < 0) {
                    // deposit
                    temp = 0;
                }
            }

            if (temp > d) {
                // overshot
                System.out.println(-1);
                in.close();
                return;
            }
        }

        int deposits = 0;
        dpArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dpArr[i] = arr[i];
            dpArr[i] += dpArr[i-1];

            if (dpArr[i] > d) {
                dpArr[i] = d;
            }

            if (arr[i] == 0) {
                if (dpArr[i] < 0) {
                    // top up to the fullest
                    dpArr[i] = d;
                    deposits = deposits + 1;
                }
            }
        }

        System.out.println(deposits);
        in.close();
    }
}