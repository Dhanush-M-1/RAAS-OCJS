import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            Scanner sc = new Scanner(in);

            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int n = sc.nextInt();

                String[] mtx = new String[n];
                for (int i = 0; i < n; i++) mtx[i] = sc.next();

                String fa1 = "1 2";
                String fa2 = "2 1";
                String fb1 = (n - 1) + " " + (n);
                String fb2 = (n) + " " + (n - 1);

                List<String> ret1 = new ArrayList<>();
                List<String> ret2 = new ArrayList<>();

                if (mtx[0].charAt(1) == '0') ret1.add(fa1);else ret2.add(fa1);
                if (mtx[1].charAt(0) == '0') ret1.add(fa2);else ret2.add(fa2);
                if (mtx[n-2].charAt(n-1) == '1') ret1.add(fb1);else ret2.add(fb1);
                if (mtx[n-1].charAt(n-2) == '1') ret1.add(fb2);else ret2.add(fb2);

                List<String> ret = ret1.size() < ret2.size() ? ret1 : ret2;
                out.println(ret.size());
                for (String s : ret) {
                    out.println(s);
                }
            }
        }
    }

}
