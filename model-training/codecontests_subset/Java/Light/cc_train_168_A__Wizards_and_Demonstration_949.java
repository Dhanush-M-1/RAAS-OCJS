import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int a = myScanner.nextInt(), b = myScanner.nextInt(), n = myScanner
                .nextInt();
        System.out.println((int) Math.max(Math.ceil((a * n * 1.0) / 100.0) - b,
                0));
    }
}
