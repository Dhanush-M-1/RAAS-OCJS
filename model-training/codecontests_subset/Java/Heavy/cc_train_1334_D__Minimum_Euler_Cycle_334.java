import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        for (int te = 0; te < t; te++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long n = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long start = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                //System.out.println("START BEFORE " + start);
                if (start > r) {
                    break;
                }
                if (start + (n-i)*2 - 1 < l) {
                    start += (n-i)*2;
                    continue;
                }
                //System.out.println("START AFTER " + start);
                for (int k = i+1; k <= n; k++) {
                    if (start >= l && start <= r) {
                        sb.append(i);
                        sb.append(' ');
                    }
                    start++;
                    if (start >= l && start <= r) {
                        sb.append(k);
                        sb.append(' ');
                    }
                    start++;
                }
            }
            if (start == r) {
                sb.append('1');
                sb.append(' ');
            }
            out.println(sb.toString());
        }
        out.close();
    }

}
/*
1
3 1 7


 */
