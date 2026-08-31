import java.util.Scanner;

public class OldFloppyDrive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        
        for (int i = 0; i < t; ++i) {
            String[] parts = sc.nextLine().split(" ");
            int n = Integer.valueOf(parts[0]);
            int m = Integer.valueOf(parts[1]);
            int[] a = new int[n];
            int[] x = new int[m];

            parts = sc.nextLine().split(" ");
            for (int j = 0; j < n; ++j) {
                a[j] = Integer.valueOf(parts[j]);
            }

            parts = sc.nextLine().split(" ");
            for (int j = 0; j < m; ++j) {
                x[j] = Integer.valueOf(parts[j]);
            }

            calculate(a, x);
        }
    }

    public static void calculate(int[] a, int[] x) {
        int n = a.length;
        int m = x.length;
        long all = 0;
        long[] sums  = new long[n];
        int[] indices = new int[n];
        int end = -1;
        for (int i = 0; i < n; ++i) {
            all += a[i];
            if (end == -1 || all > sums[end]) {
                sums[++end] = all;
                indices[end] = i;
            }
        }

        for (int j = 0; j < m; ++j) {
            int value = x[j];
            if (all <= 0 && sums[end] < value) {
                System.out.print(-1 + " ");
                continue;
            }

            boolean found = false;
            if (sums[end] >= value) {
                for (int i = 0; i <= end; ++i) {
                    if (sums[i] >= value) {
                        System.out.print(indices[i] + " ");
                        found = true;
                        break;
                    }
                }
            }
            if (found) continue;
            
            long times = (value - sums[end] + all - 1) / all;
            value -= all * times;
            if (sums[0] >= value) {
                System.out.print(times*n + indices[0] + " ");
                continue;
            }

            int k = 0;
            int b = end;
            while (b > 0) {
                if (k + b > end || sums[k + b] >= value) {
                    b /= 2;
                } else {
                    k += b;
                }
            }
            System.out.print(times*n + indices[k + 1] + " ");
        }
        System.out.println();
    }

}
