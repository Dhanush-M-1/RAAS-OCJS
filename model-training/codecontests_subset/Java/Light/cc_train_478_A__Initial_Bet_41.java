import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shubheksha on 23/3/15.
 */
public class P478A {
    public static void main(String[] args) throws IOException {
        BufferedReader o = new BufferedReader(new InputStreamReader(System.in));
        String[] in = o.readLine().split(" ");
        int i, sum = 0;
        for (i = 0; i < 5; i++) {
            sum += Integer.parseInt(in[i]);
        }
        if (sum % 5 != 0 || sum == 0)
            System.out.print("-1");
        else
            System.out.print(sum/5);
    }
}
