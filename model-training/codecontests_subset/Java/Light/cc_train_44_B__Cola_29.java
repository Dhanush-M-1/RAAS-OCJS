
import java.util.HashSet;
import java.util.Scanner;

public class B44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int res = 0;
        for (int aa = 0 ; aa <= a ; aa+=2) {
            for (int bb = 0 ; bb <= b ; bb++) {
                int nn = n - (aa / 2) - bb;
                if (nn % 2 == 0 && nn / 2 <= c && nn >= 0) res++;
            }
        }
        System.out.println(res);
    }
}
