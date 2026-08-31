
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[] = new int[n];
        int h[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        int lastPos = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                lastPos = x[i];
                count++;
            } else if (x[i] - h[i] > lastPos) {
                lastPos = x[i];
                count++;
            } else if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
                lastPos = x[i] + h[i];
                count++;
            } else {
                lastPos = x[i];
            }
        }
        System.out.println(count);

    }
}