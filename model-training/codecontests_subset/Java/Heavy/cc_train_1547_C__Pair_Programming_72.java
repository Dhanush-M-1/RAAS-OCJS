import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int z = 0; z < t; z++) {
            int k = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int[] mono = new int[n];
            int[] poly = new int[m];
            int[] ans = new int[n + m];
            for (int i = 0; i < n; i++) {
                mono[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                poly[i] = in.nextInt();
            }
            int i = 0, j = 0, fl = 0;
            boolean tf = true;
            boolean locked1=false, locked2=false;
            while (i < n || j < m) {
                if (i < n) {
                    if (mono[i] <= k) {
                        ans[fl] = mono[i];
                        fl++;
                        if (mono[i] == 0)
                            k++;
                        i++;
                        locked1 = false;
                    } else {
                        locked1 = true;
                    }
                } else {
                    locked1 = true;
                }
                if (locked1 && locked2) {
                    tf = false;
                    break;
                }
                if (j < m) {
                    if (poly[j] <= k) {
                        ans[fl] = poly[j];
                        fl++;
                        if (poly[j] == 0)
                            k++;
                        j++;
                        locked2 = false;
                    } else {
                        locked2 = true;
                    }
                } else {
                    locked2 = true;
                }
            }
            if (tf) {
                for (int ii = 0; ii < n + m; ii++) {
                    System.out.print(ans[ii] + " ");
                }
                System.out.println();
            } else
                System.out.println(-1);
        }
    }
}