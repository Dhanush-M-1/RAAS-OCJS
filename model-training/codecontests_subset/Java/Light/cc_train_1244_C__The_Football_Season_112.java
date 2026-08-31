import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long numGames = scan.nextLong();
        long points = scan.nextLong();
        long pointsForWinning = scan.nextInt();
        long pointsForDraw = scan.nextInt();
        for (long draws = 0; draws <= pointsForWinning - 1; draws++) {
            long winPoints = (points - (pointsForDraw * draws));
            if (winPoints < 0) {
                break;
            }
            if (winPoints % pointsForWinning == 0 && draws + winPoints / pointsForWinning <= numGames) {
                long wins = winPoints / pointsForWinning;
                long losses = numGames - wins - draws;
                System.out.println(wins + " " + draws + " " + losses);
                return;
            }
        }
        System.out.println("-1");
    }
}
