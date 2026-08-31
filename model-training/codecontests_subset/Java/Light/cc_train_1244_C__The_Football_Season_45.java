import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    private static Long N, W, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Long.parseLong(s[0]);
        long points = Long.parseLong(s[1]);
        W = Long.parseLong(s[2]);
        D = Long.parseLong(s[3]);
        getWins(points);
    }

    private static void getWins(long points) {
        for (long draws = 0; draws <= W; draws++) {
            long drawsScore = (draws * D);
            long remainingScore = points - drawsScore;

            if (remainingScore >= 0 && remainingScore % W == 0) {
                long wins = remainingScore / W;
                if (wins + draws <= N) {
                    long losses = (N - (wins + draws));
                    System.out.println(wins + " " + draws + " " + losses);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
