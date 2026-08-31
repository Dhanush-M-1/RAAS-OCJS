import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Test {
    public static void main(String[] argv) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] count = new int[10];
        int[] temp = new int[10];
        BigInteger ans = new BigInteger("0");
        BigInteger mod = new BigInteger("998244353");
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            temp[s[i].length() - 1]++;
            for (int j = 0; j < s[i].length(); ++j) {
                count[j]++;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int k = 0; k < s[i].length(); ++k) {
                StringBuilder str = new StringBuilder();
                if (k != s[i].length() - 1) {
                    str.append((Integer.parseInt(s[i].substring(0, s[i].length() - k - 1)) * 2));
                }
                for (int j = 0; j < k + 1; ++j) {
                    str.append(s[i].charAt(s[i].length() - k - 1 + j));
                    str.append(s[i].charAt(s[i].length() - k - 1 + j));
                }
                ans =
                        ans.add(new BigInteger(str.toString()).multiply(new BigInteger(Integer.toString(k == s[i].length() - 1? count[k]
                                : temp[k])))).mod(mod);
            }
        }
        ans = ans.mod(mod);
        out.println(ans.toString());
        out.close();

        /**

         {4 1 1 1 1 1 1 1 1 1 1 1

         2 4 6 0 2 1 1 1 1 1 1 1}
         **/

    }
}
