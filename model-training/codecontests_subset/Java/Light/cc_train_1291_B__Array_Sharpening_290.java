import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] STRnums = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(STRnums[j]);
            }
            int maxPos = n;
            for (int pos = 1; pos < n; pos++) {
                if (nums[pos]-pos < 0) {
                    maxPos = pos-1;
                    break;
                }
            }
            boolean works = true;
            for (int pos = maxPos; pos < n; pos++) {
                if (nums[pos]-n+pos+1 < 0) {
                    out.println("No");
                    works = false;
                    break;
                }
            }
            if (works) out.println("Yes");

        }


        out.flush();
    }
}