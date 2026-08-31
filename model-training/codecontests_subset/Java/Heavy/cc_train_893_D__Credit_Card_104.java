import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by leen on 23/11/2017.
 */
public class _893D {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in, 1024*64));

        int n = scan.nextInt(), d = scan.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scan.nextInt();

        int[] upperBounds = new int[n];
        int currentUpperBound = d;
        for(int i = n-1; i >= 0; i--) {
            currentUpperBound -= a[i];
            currentUpperBound = Math.min(currentUpperBound, d);
            upperBounds[i] = currentUpperBound;
        }

        int current = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(current > upperBounds[i]) {
                System.out.println(-1);
                return;
            }

            if(a[i] == 0) {
                if(current < 0) {
                    if(upperBounds[i] < 0) {
                        System.out.println(-1);
                        return;
                    }
                    else {
                        current = upperBounds[i];
                        ans++;
                    }
                }
            }
            else {
                current += a[i];
            }
        }

        System.out.println(ans);
    }

}
