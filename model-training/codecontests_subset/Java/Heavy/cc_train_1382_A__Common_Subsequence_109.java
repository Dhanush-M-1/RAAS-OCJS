import java.util.Scanner;

public class A1382 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int M = in.nextInt();
            boolean[] seen = new boolean[1001];
            for (int n=0; n<N; n++) {
                int a = in.nextInt();
                seen[a] = true;
            }
            int common = -1;
            for (int m=0; m<M; m++) {
                int b = in.nextInt();
                if (seen[b]) {
                    common = b;
                }
            }
            if (common == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(1 + " " + common);
            }
        }
    }

}
