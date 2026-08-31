import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Cows_and_Poker_Game {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(reader.readLine());
            String vacas[] = reader.readLine().split("");
            int allIn = 0, in = 0;
            for (int i = 0; i < n+1; i++) {
                if ("I".equals(vacas[i])) in++;
                else if ("A".equals(vacas[i])) allIn++;
            }
            if (in > 1) {
                System.out.println("0");
            } else if (in == 1) {
                System.out.println("1");
            } else {
                System.out.println(allIn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
