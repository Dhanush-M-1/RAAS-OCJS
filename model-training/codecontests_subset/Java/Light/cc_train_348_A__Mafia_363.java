
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        String[] nums = reader.readLine().split(" ");
        long sum = 0, max = -99;

        for (int i = 0; i < nums.length; i++) {
            int temp = Integer.parseInt(nums[i]);
            if (temp > max) {
                max = temp;
            }
            sum += temp;
        }
        if (max > (long) Math.ceil(sum * 1.0 / (nums.length - 1))) {
            System.out.println(max);
        } else {
            System.out.println((long) Math.ceil(sum * 1.0 / (nums.length - 1)));
        }

        reader.close();
    }

}