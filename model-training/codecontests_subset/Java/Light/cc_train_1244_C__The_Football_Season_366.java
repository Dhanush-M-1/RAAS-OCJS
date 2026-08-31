import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int q = 1;
        for (int i = 0; i < q; i++) {
            String[] line = rd.readLine().split(" ");
            long n = Long.parseLong(line[0]);
            long p = Long.parseLong(line[1]);
            long w = Long.parseLong(line[2]);
            long d = Long.parseLong(line[3]);
            for (long W = 0; W <= 150_000; W++) {
                long win = W * w;
                if (win > p || (p - win) % d != 0) continue;
                long D = (p - win) / d;
                long draw = D * d;
                if (win + draw == p && W + D <= n) {
                    pw.println(W + " " + D + " " + (n - (W + D)));
                    pw.flush();
                    return;
                }
            }
            for (long D = 0; D <= 150_000; D++) {
                long draw = D * d;
                if (draw > p || (p - draw) % w != 0) continue;
                long W = (p - draw) / w;
                long win = W * w;
                if (win + draw == p && W + D <= n) {
                    pw.println(W + " " + D + " " + (n - (W + D)));
                    pw.flush();
                    return;
                }
            }
            pw.println(-1);
        }
        pw.flush();
    }
}