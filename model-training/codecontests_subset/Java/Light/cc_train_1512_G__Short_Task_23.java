import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G {
    private void work() {

        int lim = 10000000;
        int[] d = new int[lim + 1];
        Arrays.fill(d, 1);
        long ops = 0;
        for (int i = 2; i < d.length; i++) {
            for (int j = i; j < d.length; j += i) {
                d[j] += i;
                ops++;
            }
        }

        int[] a = new int[lim + 1];
        for (int i = 1; i < d.length; i++) {
            if (d[i] <= lim && a[d[i]] == 0) a[d[i]] = i;
        }

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in), 1 << 16));
        int nc = sc.nextInt();
        while (nc-- > 0) {
            int c = sc.nextInt();
            int ans = -1;
            if (a[c] > 0) ans = a[c];
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        new G().work();
    }
}
