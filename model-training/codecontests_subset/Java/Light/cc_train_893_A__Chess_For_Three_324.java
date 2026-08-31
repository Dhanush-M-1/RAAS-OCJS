import java.util.Scanner;

public class A893 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int player1 = 1;
        int player2 = 2;
        int spectator = 3;
        boolean ok = true;
        for (int n=0; n<N; n++) {
            int winner = in.nextInt();
            if (winner == spectator) {
                ok = false;
                break;
            } else if (winner == player1) {
                winner = player2;
                player2 = spectator;
                spectator = winner;
            } else {
                winner = player1;
                player1 = spectator;
                spectator = winner;
            }
        }
        System.out.println(ok ? "YES" : "NO");
    }

}
