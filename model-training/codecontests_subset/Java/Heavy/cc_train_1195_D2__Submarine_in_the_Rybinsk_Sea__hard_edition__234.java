import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        BigInteger[] a = new BigInteger[n];
        int razr = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = BigInteger.valueOf(s.nextLong());
            razr = Math.max(razr, a[i].toString().length());
        }
        int[] rs = new int[razr + 1];
        for (int i = 0; i <= razr; ++i) {
            rs[i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            ++rs[a[i].toString().length()];
        }
        BigInteger[] tens = new BigInteger[2 * razr + 10];
        tens[0] = BigInteger.ONE;
        for (int i = 1; i < tens.length; ++i) {
            tens[i] = tens[i - 1].multiply(new BigInteger("10"));
        }

        BigInteger ans = new BigInteger("0");
        BigInteger nn = BigInteger.valueOf(n);
        BigInteger[] rrs = new BigInteger[rs.length];
        for (int i = 0; i < rs.length; ++i) {
            rrs[i] = BigInteger.valueOf(rs[i]);
        }
        for (int i = 0; i < razr; ++i) {
            for (int j = 0; j < n; ++j) {
                BigInteger aa = a[j].divide(tens[i]);
                int how = 0;
                aa = aa.mod(new BigInteger("10"));
                for (int q = 1; q <= i; ++q) {
                    how += rs[q];
                    BigInteger multiply = aa.multiply(rrs[q]).multiply(tens[i + q]);
                    ans = ans.add(multiply);
                    ans = ans.add(multiply);
                }
                ans = ans.add(aa.multiply(nn.subtract(BigInteger.valueOf(how))).multiply(tens[2 * i]));
                ans = ans.add(aa.multiply(nn.subtract(BigInteger.valueOf(how))).multiply(tens[2 * i + 1]));
            }
        }
        System.out.println(ans.mod(new BigInteger("998244353")).toString());
    }
}