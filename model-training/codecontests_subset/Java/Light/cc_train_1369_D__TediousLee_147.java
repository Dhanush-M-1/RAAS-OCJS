import java.util.Scanner;

public class demo_D {
    public static void main(String[] args) {
        StringBuilder pt = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        long[] a = new long[2000001];
        a[2] = 0;
        a[1] = 0;
        for (int i = 3; i < 2000001; i++) {//总共有多少个节点
            a[i] = (a[i - 1]) % 1000000007;
            a[i] += (2 * a[i - 2]) % 1000000007;
            //pt.append(a[i]).append(" ");
            if (i % 3 == 0) {
                a[i] += 1;
            }
            a[i] = a[i] % 1000000007;
        }
        while (t-- != 0) {
            int n = scan.nextInt();
            long x = (a[n] * 4) % 1000000007;
            pt.append(x).append('\n');
        }
        System.out.println(pt);
    }
}