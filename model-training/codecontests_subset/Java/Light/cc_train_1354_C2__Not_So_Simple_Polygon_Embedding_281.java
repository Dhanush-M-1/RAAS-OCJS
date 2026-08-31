import java.util.Locale;
import java.util.Scanner;

public class C1354 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int n = in.nextInt();
            int sides = 2*n;
            double answer;
            if (n%2 == 0) {
                answer = squareSize(sides, Math.PI/sides);
            } else {
                answer = squareSize(sides, Math.PI/4);
            }
            System.out.println(answer);
        }
    }

    static double squareSize(int sides, double rotation) {
        double r = 1/(2*Math.sin(Math.PI/sides));
        double minx = Double.MAX_VALUE;
        double maxx = Double.MIN_VALUE;
        double miny = Double.MAX_VALUE;
        double maxy = Double.MIN_VALUE;
        for (int n=0; n<sides; n++) {
            double alpha = rotation + n*2*Math.PI/sides;
            double x = r*Math.cos(alpha);
            double y = r*Math.sin(alpha);
            minx = Math.min(minx, x);
            maxx = Math.max(maxx, x);
            miny = Math.min(miny, y);
            maxy = Math.max(maxy, y);
        }
        double side = Math.max(maxy-miny, maxx-minx);
        return side;
    }

}
