import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author emorenkov
 */
public class WoodCutterC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            x[i] = Integer.valueOf(split[0]);
            h[i] = Integer.valueOf(split[1]);
        }
        int totalWoods = 1;
        int leftBorder = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (x[i] - h[i] > leftBorder) {
                totalWoods++;
                leftBorder = x[i];
            } else if (x[i] + h[i] < x[i + 1]) {
                totalWoods++;
                leftBorder = x[i] + h[i];
            } else {
                leftBorder = x[i];
            }
        }
        System.out.println(totalWoods);
    }
}