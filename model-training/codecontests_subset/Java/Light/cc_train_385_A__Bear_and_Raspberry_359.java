import java.util.Scanner;

public class BearBuisness {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int c = scan.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = scan.nextInt();

        int max = 0;

        for (int i = 0; i < n-1; i++) {
            max = Math.max(max, x[i] - x[i+1] - c);
        }

        System.out.println(max);
    }
}
