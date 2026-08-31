import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static java.lang.System.currentTimeMillis;

public class JCAddOne {
    public static void main(String[] args) throws IOException {
//        long start = currentTimeMillis();
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader file = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
//        "5\n1912 1\n5 6\n999 1\n88 2\n12 100".getBytes())));
//        "1\n12 100".getBytes())));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(file.readLine());
        int modulo = (int) 1e9 + 7;
        long[] cache = new long[200005];

        for (int i = 0; i <= 8; i++) cache[i] = 2L;
        cache[9] = 3L;
        for (int i = 10; i <= 200004; i++) cache[i] = (cache[i - 9] + cache[i - 10]) % modulo;
        
        var it = 0;
        while (it < t) {
            String[] a = file.readLine().split(" ");
            int ab = Integer.parseInt(a[0]);
            int b = Integer.parseInt(a[1]);
            var ints = ab;
            var sum = 0L;
            while (ints > 0) {
                int i = (int) (ints % 10);
                if (b + i - 10 >= 0)
                    sum = (sum + cache[b + i - 10]) % modulo;
                else
                    sum = sum + 1;
                ints /= 10;
            }
            out.println(sum);
            it += 1;
        }
//        out.println(currentTimeMillis() - start);
        out.close();
    }
}