import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), k = 0, sum = 0;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
            if (a[i] > k) k = a[i];
        }

        while (k*n - sum <= sum) {
            k++;
        }

        System.out.println(k);
    }
}
