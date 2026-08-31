import java.util.Scanner;

public class C545 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 1;
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; ++i) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        int limit = x[0];
        for (int i = 1; i < n - 1; ++i) {
            if (x[i] - h[i] > limit) {
                count++;
                limit = x[i];
            } else if (x[i] + h[i] < x[i + 1]) {
                count++;
                limit = x[i] + h[i];
            } else {
                limit = x[i];
            }
        }
        System.out.println(count + (n > 1 ? 1 : 0));
    }

}
