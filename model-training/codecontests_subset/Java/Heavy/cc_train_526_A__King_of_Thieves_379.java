import java.util.Scanner;
/**
 * Created by loremon long time ago.
 */

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        boolean [] a;
        String s;
        boolean f;
        int i, j, k, n;
        n = Integer.valueOf(read.next());
        s = read.next();
        a = new boolean[n];
        for (i=0; i<n; i++) {
            if (s.charAt(i) == '*') a[i]=true;
            else a[i]=false;
        }
        for (i=0; i<n; i++) {
            if (!a[i]) continue;
            for (j=1; j<n; j++) {
                f=true;
                for (k=1; k<5; k++) {
                    if (i+k*j>=n) {
                        f=false;
                        break;
                    }
                    if (!a[i+k*j]) {
                        f=false;
                        break;
                    }

                }
                if (f) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");


    }
}
