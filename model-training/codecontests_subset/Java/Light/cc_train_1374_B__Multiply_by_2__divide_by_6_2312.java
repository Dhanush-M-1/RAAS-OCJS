import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        boolean possible = false;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int moves = 0;
            while (n % 6 == 0) {
                n /= 6;
                moves++;
            } while (n % 3 == 0) {
                n /= 3;
                moves += 2;
            }
            if (n != 1) moves = -1;
            System.out.println(moves);
        }
    }
}
