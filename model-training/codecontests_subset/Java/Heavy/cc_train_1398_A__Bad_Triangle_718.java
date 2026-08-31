import java.util.Scanner;

public class Cf1398a {
    private static void solve(int[] as) {
        if (as[0] + as[1] > as[as.length - 1]) {
            System.out.println("-1");
        } else {
            System.out.println(String.format("%d %d %d", 1, 2, as.length));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int test = input.nextInt(); test > 0; test--) {
            int n = input.nextInt();
            int[] as = new int[n];
            for (int i = 0; i < n; i++) {
                as[i] = input.nextInt();
            }
            solve(as);
        }
    }
}
