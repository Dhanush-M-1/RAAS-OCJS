import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String... args) {
        int N = IN.nextInt();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += IN.nextInt();
        }
        puts(ans - N);
    }
    static final Scanner IN = new Scanner(System.in);
    static <T> void puts(T arg) { System.out.println(arg); }
}