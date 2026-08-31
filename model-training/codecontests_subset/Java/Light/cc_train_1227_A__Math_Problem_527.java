import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int lMax = 0;
            int rMin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                lMax = Math.max(lMax, scanner.nextInt());
                rMin = Math.min(rMin, scanner.nextInt());
            }
            System.out.println(Math.max(lMax - rMin, 0));
        }
    }
}