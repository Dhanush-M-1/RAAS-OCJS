import java.math.*;
import java.util.*;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        int n; n = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                Long x = (long) i * j;
                System.out.print(Long.toString(x, n));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}