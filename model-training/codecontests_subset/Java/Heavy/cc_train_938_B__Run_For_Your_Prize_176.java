import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunForYourPrize {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfPrizes = Integer.parseInt(reader.readLine());
        int[] prizes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int timeSpent = 0;
        for (int prizePosition : prizes) {
            int distanceToFirst = prizePosition - 1;
            int distanceToSecond = 1_000_000 - prizePosition;
            timeSpent = Math.max(timeSpent, Math.min(distanceToFirst, distanceToSecond));
        }
        System.out.println(timeSpent);
    }
}
