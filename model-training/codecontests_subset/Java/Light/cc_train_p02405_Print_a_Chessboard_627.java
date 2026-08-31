import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            int H = input.nextInt();
            int W = input.nextInt();
            if (H == 0 && W == 0) break;
            for (int i = 1; i <= H; i++) {
                char[] cs = new char[W];
                for (int j = 1; j <= W; j++) {
                    cs[j-1] = ((j + i) % 2 == 0) ? '#' : '.';
                }
                System.out.println(cs);
            }
            System.out.println();
        }
    }
}