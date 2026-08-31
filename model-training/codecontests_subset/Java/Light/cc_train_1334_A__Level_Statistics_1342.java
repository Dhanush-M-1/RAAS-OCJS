import java.io.PrintWriter;
import java.util.Scanner;

public class LevelStats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int maxT = 0;
            int maxC = 0;
            boolean check = true;
            for (int index = 0; index < N; index++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a < b) {
                    check = false;
                    // break;
                }
                if (maxT > a) {
                    check = false;
                    // break;
                }
                if (maxC > b) {
                    check = false;
                    // break;
                }
                if (a - maxT < b - maxC) {
                    check = false;
                    // break;
                }
                maxT = a;
                maxC = b;
            }
            if (check == false) {
                out.println("NO");
            } else {
                out.println("YES");
            }

        }
        out.close();

    }

}
