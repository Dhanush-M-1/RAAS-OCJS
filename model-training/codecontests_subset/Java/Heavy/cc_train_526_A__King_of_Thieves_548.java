import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Андрей on 04.04.2015.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(in.readLine());
        String path = in.readLine();

        for (int i = 0; i < N - 4; ++i) {
            if (path.charAt(i) == '.') continue;
            for (int j = 1; j <= (N - 5 - i) / 4 + 1; ++j) {
                boolean flag = true;
                for (int k = 1; k < 5; ++k) {
                    //System.out.print(path.charAt(i + j));
                    if (path.charAt(i + j * k) != '*') {
                        flag = false;
                        break;
                    }
                }
                //System.out.println();
                if (flag) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
}
