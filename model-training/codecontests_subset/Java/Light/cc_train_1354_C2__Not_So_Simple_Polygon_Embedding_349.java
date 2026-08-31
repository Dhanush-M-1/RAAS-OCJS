import java.util.Scanner;

public class ProblemC2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long T = s.nextInt();
        while (T-- > 0) {
            int n = s.nextInt();
            double radians = Math.toRadians(45);
            double side = 0;
            for(int i=0; i<2*n; ++i) {
                side+= Math.abs(Math.sin(radians));
                radians+=Math.PI/n;
            }
            System.out.println(side/2);
        }
    }
}
