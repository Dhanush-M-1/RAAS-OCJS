import java.util.Scanner;

public class P102E {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        long xA = inScanner.nextLong();
        long yA = inScanner.nextLong();
        long xB = inScanner.nextLong();
        long yB = inScanner.nextLong();
        long xC1 = inScanner.nextLong();
        long yC1 = inScanner.nextLong();
        long xC2 = yC1;
        long yC2 = -xC1;
        for (int i = 0; i < 4; i++) {
            long xDiff = xB - xA;
            long yDiff = yB - yA;
            if (xDiff == 0 && yDiff == 0) {
                System.out.println("YES");
                return;
            }
            double coord1 = (double) (xDiff * xC1 + yDiff * yC1)
                    / (xC1 * xC1 + yC1 * yC1);
            double coord2 = (double) (xDiff * xC2 + yDiff * yC2)
                    / (xC2 * xC2 + yC2 * yC2);
            if (Math.abs(Math.floor(coord1) - coord1) < Double.MIN_VALUE
                    && Math.abs(Math.floor(coord2) - coord2) < Double.MIN_VALUE) {
                System.out.println("YES");
                return;
            }
            long temp = xA;
            xA = yA;
            yA = -temp;
        }
        System.out.println("NO");
    }
}
