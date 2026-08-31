
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, po, ne, i, j, k;
        n = input.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        for (i = 0, j = 0, k = 0; k < n; k++) {
            int tem = input.nextInt();
            if (tem % 2 == 0) a1[i++] = tem;
            else a2[j++] = tem;
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        long ans = 0;
        if (i > j) {
            j++;
            for (int l = n-1-j; l >= 0; l--) ans += a1[l];
        } else {
            i++;
            for (int l = n-1-i; l >= 0; l--) ans+= a2[l];
        }
        System.out.println(ans);
    }
}