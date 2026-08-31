import java.util.Scanner;

public class MisterB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int c = scanner.nextInt();
        int v = scanner.nextInt();
        int v1 = scanner.nextInt();
        int a = scanner.nextInt();
        int l = scanner.nextInt();

        System.out.println(solve(c, v, v1, a, l));

    }

    public static int solve(int c, int v, int v1, int a, int l) {
        int counter = 0;
        for (int i = 0; i < c; i += v) {
            if (i != 0) {
                if (v + a < v1) {
                    v += a;
                } else {
                    v = v1;
                }
                i -= l;
            }
            counter++;
        }
        return counter;
    }
}