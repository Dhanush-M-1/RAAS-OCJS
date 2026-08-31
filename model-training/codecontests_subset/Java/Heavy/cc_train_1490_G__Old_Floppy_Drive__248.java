import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t, n, m;

        t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();
            m = in.nextInt();
            long[] a = new long[n];
            long[] maxx = new long[n];
            long[] summ = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = in.nextLong();
                summ[i] = a[i];
                if (i > 0) {
                    summ[i] += summ[i-1];
                }
            }
            maxx[0] = summ[0];
            for (int i = 1; i < n; i++) {
                maxx[i] = Math.max(summ[i], maxx[i-1]);
            }

            while (m-- > 0) {
                long x = in.nextLong();
                long ans = 0;
                long y = 0;
                if (y + maxx[n - 1] < x) {
                    if (y + summ[n-1] <= 0) {
                        ans = -1;
                    } else {
                        ans += (x-maxx[n-1]) / summ[n - 1] * n;
                        y += (x-maxx[n-1]) / summ[n - 1] * summ[n - 1];
                        if ((x-maxx[n-1]) % summ[n-1] != 0) {
                            ans += n;
                            y += summ[n-1];
                        }
                    }
                }
                if (ans == -1) {
                    System.out.print(ans + " ");
                    continue;
                }
                if (y < x) {
                    int l = 0, r = n - 1, anss = 0;
                    while (l <= r) {
                        int mid = (l + r) / 2;
                        if (maxx[mid] + y >= x) {
                            anss = mid;
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                    ans += anss;
                }
                System.out.print(ans + " ");
            }
            System.out.println();



        }
    }


}
