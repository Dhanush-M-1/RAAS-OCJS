import sun.security.util.BigInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: AUtemuratov
 * Date: 07.04.14
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    static int k,d,n,sum,cnt;
    static Integer a[] = new Integer[11111];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer tk = new StringTokenizer(bf.readLine(), "+");

        int i =1;
        while(tk.hasMoreTokens()) {
            a[i++] = Integer.parseInt(tk.nextToken());
        }
        i--;
        Arrays.sort(a, 1, i + 1);

        for (int j=1; j<=i; j++) {
            pw.print(a[j]);
            if (j!=i) {
                pw.print("+");
            }
        }
        pw.close();
        }

}