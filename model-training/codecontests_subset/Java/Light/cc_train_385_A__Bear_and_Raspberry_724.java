import java.util.Scanner;


public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int max = 0;
        int x1 = in.nextInt();
        for (int i=2; i<=n; i++) {
            int x2 = in.nextInt();
            int curMax = x1 - x2 - c;
            if (curMax > max) {
                max = curMax;
            }
            x1 = x2;
        }
        System.out.println(max);
    }

}
