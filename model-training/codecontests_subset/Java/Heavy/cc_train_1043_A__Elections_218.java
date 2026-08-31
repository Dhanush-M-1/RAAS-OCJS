
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            in.readLine();
            String[] tokens = in.readLine().split(" ");
            int[] numbers = new int[tokens.length];
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < tokens.length; i++) {
                numbers[i] = Integer.parseInt(tokens[i]);
                max = Math.max(max, numbers[i]);
                sum += numbers[i];
            }
            if (sum < (max * numbers.length) - sum) {
                System.out.println(max);
                return;
            }
            System.out.println((sum * 2 / numbers.length) + 1);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
