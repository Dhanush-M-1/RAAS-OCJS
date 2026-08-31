import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        if (a + b == c || a + c == b || b + c == a) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}