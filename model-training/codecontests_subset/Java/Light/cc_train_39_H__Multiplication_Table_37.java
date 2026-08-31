import java.util.Scanner;

public class P039H {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int k = inScanner.nextInt();
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++)
                System.out.print(Integer.toString(i * j, k) + " ");
            System.out.println();
        }
    }
}
