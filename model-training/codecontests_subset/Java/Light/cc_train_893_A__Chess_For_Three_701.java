import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] p = new int[2];
        p[0] = 1;
        p[1] = 2;
        int w = 3;
        for (int i = 0; i < n; i++) {
            int nn = s.nextInt();
            if (nn != p[0])
                if (nn != p[1]) {
                    System.out.print("NO");
                    return;
                }

            if (nn == p[0]) {
                int c = p[1];
                p[1] = w;
                w = c;
            } else {
                int c = p[0];
                p[0] = w;
                w = c;
            }
        }
        System.out.println("YES");
    }


}
