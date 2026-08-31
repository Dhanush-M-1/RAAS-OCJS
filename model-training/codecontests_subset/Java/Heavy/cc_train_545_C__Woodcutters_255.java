import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] h = new long[n];
        long[] x = new long[n];
        for(int i = 0; i < n; i++) {
            x[i] = scanner.nextLong();
            h[i] = scanner.nextLong();
        }
        int ans = 0;
        if(n > 0)
            ans++;
        if(n > 1)
            ans++;
        for(int i = 1; i < n-1; i++) {
            if(x[i] - h[i] > x[i-1]) {
                ans++;
            }
            else if(x[i] + h[i] < x[i+1]) {
                ans++;
                x[i] += h[i];
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}