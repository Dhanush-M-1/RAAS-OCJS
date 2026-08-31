/**
 * Created by MalhotR1 on 2/17/2017.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class CompliationErrors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] in1 = br.readLine().trim().split(" ");
        String[] in2 = br.readLine().trim().split(" ");
        String[] in3 = br.readLine().trim().split(" ");
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        for (int i = 0; i < in1.length; i++) {
            sum1 += Long.parseLong(in1[i]);
        }
        for (int i = 0; i < in2.length; i++) {
            sum2 += Long.parseLong(in2[i]);
        }
        for (int i = 0; i < in3.length; i++) {
            sum3 += Long.parseLong(in3[i]);
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);

    }
}
