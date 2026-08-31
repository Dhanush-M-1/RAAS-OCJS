import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        double p = n * y * 1.0 / 100.0;
        int cnt = 0;
        while (x < p) {
            cnt++;
            x++;
        }
        System.out.println(cnt);
    }
}