import java.util.Scanner;

public class MathProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int maxL = Integer.MIN_VALUE;
            int minR = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int l = scan.nextInt();
                if (l > maxL) {
                    maxL = l;
                }
                int r = scan.nextInt();
                if (r < minR) {
                    minR = r;
                }
            }
            int minSegment = Math.max(0,(maxL - minR));
            System.out.println(minSegment);
        }
    }
}
