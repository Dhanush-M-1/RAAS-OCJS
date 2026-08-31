import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int player1 = 1, player2 = 2, other = 3;
        for (int i = 0; i < n; i++) {
            int win = in.nextInt();
            if (win == other) {
                System.out.println("NO");
                return;
            } else if (win == player1) {
                player1 = win;
                player2 = swap(other, other = player2);
            } else {
                player2 = win;
                player1 = swap(other, other = player1);
            }
        }
        System.out.println("YES");
    }
    private static int swap(int a, int b) {
        return a;
    }
}