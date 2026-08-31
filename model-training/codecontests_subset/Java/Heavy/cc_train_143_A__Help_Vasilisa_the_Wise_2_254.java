import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        int r2 = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int d1 = in.nextInt();
        int d2 = in.nextInt();
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        if (a != b && a != c && a != d && b != c && b != d
                                && c != d) {
                            if(a+b == r1 && c +d == r2 && a + c == c1 && b+d == c2 && a+d == d1 && c+b == d2){
                                System.out.println(a+" "+b);
                                System.out.println( c+" "+d);
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}