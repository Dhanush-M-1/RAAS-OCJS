import java.io.*;
import java.util.*;

public class CF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] factors1 = new int[6];
        int[] factors2 = new int[6];

        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (a % num == 0) {
                a /= num;
                factors1[num]++;
            }

            while (b % num == 0) {
                b /= num;
                factors2[num]++;
            }
        }

        if (a != b) {
            pw.println(-1);
        } else {
            int ret = 0;

            for (int num : nums) {
                ret += Math.abs(factors1[num] - factors2[num]);
            }

            pw.println(ret);
        }

        pw.close();
    }
}