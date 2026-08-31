import java.util.Scanner;

public class Prob2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            a[in.nextInt()-1]++;
        }
        int result = 0;
        int left = n;
        for (int i = 0; i < m; i++) {
            result += a[i] * (left - a[i]);
            left -= a[i];
        }
        System.out.println(result);
    }
    
}