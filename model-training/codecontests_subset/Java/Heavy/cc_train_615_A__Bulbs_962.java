import java.io.IOException;
import java.util.*;

public class Main {

    private static int[][] mem;
    private static int[][] col;
    private static int[][] row;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int b  = in.nextInt();
        int l = in.nextInt();
        boolean[] can = new boolean[l];
        int cnt = 0;
        for (int i = 0; i < b; ++i) {
            int x = in.nextInt();
            for (int j = 0; j < x; ++j) {
                int index = in.nextInt() - 1;
                if (!can[index]) {
                    can[index] = true;
                    ++cnt;
                }
            }
        }

        System.out.println(cnt == l ? "YES" : "NO");
    }
}