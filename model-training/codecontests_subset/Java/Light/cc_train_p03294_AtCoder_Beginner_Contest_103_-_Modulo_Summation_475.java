import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // input
            int N = Integer.parseInt(sc.next());
            int ans = 0;
            for (int i = 0; i < N; i++) {
                ans += Integer.parseInt(sc.next()) - 1;
            }
            System.out.println(ans);
        }
    }
}
