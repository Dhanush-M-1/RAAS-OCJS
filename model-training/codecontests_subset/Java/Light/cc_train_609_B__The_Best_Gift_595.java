import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int val, ans = 0;
        int a[] = new int[15];
        for (int i = 0; i < n; i++) {
            val = scan.nextInt();
            a[val]++;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) { 
                ans += a[i] * a[j];
            }

        }
        System.out.println(ans);

    }

}
