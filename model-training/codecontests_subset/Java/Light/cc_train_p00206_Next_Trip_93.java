import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int r = 0;
            for (int i = 1; i < 13; i++) {
                n -= sc.nextInt() - sc.nextInt();
                if (n <= 0 && r == 0) {
                    r = i;
                }
            }
            System.out.println(n <= 0 ? r : "NA");
        }
    }
}
