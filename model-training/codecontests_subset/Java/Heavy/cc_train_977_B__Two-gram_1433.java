import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.max;




public class Main {

 

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String word = sc.next();

        int max = 0;
        String result = "";
        for (int i = 0; i < n - 1; ++i) {
            int count = 1;
            String gram = word.charAt(i) + "" + word.charAt(i + 1);
            String occ = gram;
            for (int j = i + 1; j < n-1; ++j) {
                if ((word.charAt(j) + "" + word.charAt(j + 1)).equals(gram)) {
                    count++;
                    occ = gram;
                }

            }
            if (count > max) {
                max = count;
                result = occ;
            }
        }

        System.out.println(result);
    }
}