import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] sum = br.readLine().replaceAll("\\+", "").toCharArray();
        Arrays.sort(sum);

        String out = "" + sum[0];
        for (int i = 1; i < sum.length; i++) {
            out += "+" + sum[i];
        }

        System.out.println(out);

        br.close();
    }
}
