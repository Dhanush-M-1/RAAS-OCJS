import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[m];
        int[] d = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int ans = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int tmp1 = Math.abs(a[i] - c[j]);
                int tmp2 = Math.abs(b[i] - d[j]);
                if(min > tmp1 + tmp2) {
                    min = tmp1 + tmp2;
                    ans = j + 1;
                }
            }
            System.out.println(ans);
        }
    }
}
