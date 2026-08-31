import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static final int dir[][] = { { 1, 0, 0, 1 }, { -1, 0, 0, -1 },
            { 0, -1, 1, 0 }, { 0, 1, -1, 0 } };

    public void run() {
        long ax = cin.nextLong();
        long ay = cin.nextLong();
        long bx = cin.nextLong();
        long by = cin.nextLong();
        long cx = cin.nextLong();
        long cy = cin.nextLong();
        for (int i = 0; i < 4; ++i) {
            long dx = bx - ax * dir[i][0] - ay * dir[i][1];
            long dy = by - ax * dir[i][2] - ay * dir[i][3];
            if (cx == 0 && cy == 0) {
                if (dx == 0 && dy == 0) {
                    System.out.println("YES");
                    return;
                }
            } else {
                long m = cx * cx + cy * cy;
                long n1 = dx * cx + dy * cy;
                long n2 = dx * cy - dy * cx;
                if (n1 % m == 0 && n2 % m == 0) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        new Main().run();
    }

    Scanner cin = new Scanner(System.in);
}
   	 			   	 		  			  	   	