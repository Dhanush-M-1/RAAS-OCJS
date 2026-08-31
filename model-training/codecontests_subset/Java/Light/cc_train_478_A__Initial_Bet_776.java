import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = 0;
        for (int i = 0; i < 5; i++) {
            k += in.nextInt();
        }

        if (k % 5 == 0 && k != 0) {
            System.out.println(k / 5);
        } else {
            System.out.println(-1);
        }
    }
}
