import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long n = Long.parseLong(in.readLine());

        if (n == 1) {
            out.println(1);
            out.println(0);
        } else {

            Vector<Long> v = new Vector<Long>();
            long nCopy=n;

            for (long i = 2; i * i <= nCopy; i++) {
                while (n % i == 0) {
                    v.add(i);
                    n /= i;
                }

                if (n == 1)
                    break;
            }

            if (n != 1)
                v.add(n);

            if (v.size() == 1) {
                out.println(1);
                out.println(0);
            } else if (v.size() == 2) {
                out.println(2);
            } else {
                out.println(1);
                long ans = 1;
                for (int i = 0; i < 2; i++)
                    ans *= v.elementAt(i);

                out.println(ans);
            }
        }

        out.close();
    }
}
