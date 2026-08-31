import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();

            int left = Integer.MAX_VALUE;
            int right = 0;

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (num < i) left = Math.min(left, i - 1);
                if (num < n - i - 1) right = i + 1;
            }


            System.out.println((left >= right) ? "Yes" : "No");
        }
    }

}
