import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T3 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            long p = 1;
            long power = 1;
            for (int i = 2; i <= n; i++) {
                p = (p*i)%1_000_000_007;
                power = (power * 2) % 1_000_000_007;
            }
            System.out.println((p + 1_000_000_007 -power)%1_000_000_007);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
