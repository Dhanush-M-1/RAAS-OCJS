import java.util.Scanner;

public class Vibori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            max = Math.max(max, next);
            sum = sum + next;
        }
        for (int j = max; ; j++) {
            if (j * n - sum > sum) {
                System.out.println(j);
                return;
            }
        }
    }
}