
import java.math.*;
import java.util.*;

public class BruteForce {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        if (n == 1) {
            System.out.println("1");
        } else {
            int[] index = new int[n];
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                index[i] = in.nextInt();
                height[i] = in.nextInt();
            }
            int count = 2;
            for (int i = 1; i < n - 1; i++) {
                if (index[i] - height[i] > index[i - 1]) {
                    count++;
                } else if (index[i] + height[i] < index[i + 1]) {
                    index[i] = index[i] + height[i];
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
