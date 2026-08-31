import java.util.*;

public class P1398A {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int [] sides = new int[n];

            for (int j = 0; j < n;j++) {
                sides[j] = in.nextInt();
            }

            Arrays.sort(sides);

            if (sides[0] + sides[1] <= sides[n -1]) {
                System.out.println("1 2 " + n);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}