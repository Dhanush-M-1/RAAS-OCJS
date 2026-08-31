import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int d = sc.nextInt();
            if (d < l) {
                System.out.println(d);
            } else {
                if ((r + 1) % d == 0) {
                    System.out.println(r + 1);
                } else {
                    System.out.println(r + 1 + (d - ((r + 1) % d)));
                }
            }
        }
    }
}