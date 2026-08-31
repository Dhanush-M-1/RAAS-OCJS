
import java.util.Scanner;

public class HelpA {

    public static void main(String[] ar) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        int r2 = in.nextInt();
        in.nextLine();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        in.nextLine();
        int d1 = in.nextInt();
        int d2 = in.nextInt();

        int a = 1, b = 1, c = 1, d = 1;
        boolean bl = false;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j + i == r1) {          
                    for (int k = 1; k <= 9; k++) {
                        if (k + i == c1 && k + j == d2 && r2-k+j==c2) {
                            a = i;
                            b = j;
                            c = k;
                            d = r2 - c;
                            bl=true;
                        }
                    }
                }
            }

        }
        if (a==b||a==c||a==d||b==c||b==d||c==d||d<1||d>9)
            bl=false;
        
        if (bl) {
        System.out.println(a+" "+b);
        System.out.println(c+" "+d);
        }
        else
            System.out.println("-1");
    }
}