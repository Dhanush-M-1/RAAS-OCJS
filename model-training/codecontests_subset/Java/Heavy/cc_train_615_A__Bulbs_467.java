import java.io.*;
import java.util.*;

public class Bulbs {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    public static void main(String[] argv) throws IOException {
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] ary = new int[m];
        while (n-- > 0) {
            tmp = br.readLine().split(" ");
            for (int i = 1; i < tmp.length; i++) {
                int index = Integer.parseInt(tmp[i])-1;
                ary[index] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (ary[i] == 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
