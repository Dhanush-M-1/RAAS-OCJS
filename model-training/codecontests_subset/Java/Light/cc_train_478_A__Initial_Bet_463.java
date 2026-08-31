import java.util.Scanner;

public class problemA {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;
//        t = in.nextInt();
        while (t != 0) {
            solve();
            t--;
        }
    }

    public static void solve() {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt(), e = in.nextInt();
        if ((a + b + c + d + e) % 5 == 0 && (a + b + c + d + e) / 5 != 0) {
            System.out.println((a + b + c + d + e) / 5);
        } else {
            System.out.println(-1);
        }
    }
}

