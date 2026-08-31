import java.util.Scanner;

public class Codeforces670B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        if (k == 1 || k == 2) {
            System.out.println(a[0]);
        } else {
            long sum = 3;
            int cur = 3;
            if (k == 3) {
                System.out.println(a[1]);
            } else {
                while (sum < k) {
                    sum += cur;
                    cur++;
                }
                System.out.println(a[(int) (cur - (sum - k) - 2)]);
            }
        }
    }


}
