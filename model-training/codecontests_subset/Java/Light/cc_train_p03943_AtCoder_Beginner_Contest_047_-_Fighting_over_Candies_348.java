import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int max = Math.max(a, Math.max(b, c));
            System.out.println((a + b + c) - max == max ? "Yes" : "No");
        }
    }
}
