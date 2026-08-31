import java.util.Scanner;

public class _195 {
    public static void main(String[] args) {
        final Scanner scn = new Scanner(System.in);

        final int a = scn.nextInt();
        final int b = scn.nextInt();
        final int c = scn.nextInt();

        System.out.println(((a - b) * c + b - 1) / b);

        scn.close();
    }
}
