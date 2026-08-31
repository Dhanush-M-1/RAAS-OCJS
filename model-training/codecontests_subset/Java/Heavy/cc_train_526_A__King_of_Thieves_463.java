import java.util.Scanner;

public class A {
    final static int N = 5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] field = in.next().toCharArray();
        for (int i = 0; i < n; i++) {
            for (int step = 1; i + step * (N - 1) < n; step++) {
                boolean all = true;
                for (int j = 0; j < N; j++) {
                    all &= field[i + step * j] == '*';
                }
                if (all) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
}
