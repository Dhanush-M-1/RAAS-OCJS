import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
//        log.flush();
        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
//        for (int t = 0; t < test; t++) {
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split("\\s");

        log.write("1 1\n");
        log.write((-Integer.parseInt(a[0])) + "\n");
        a[0] = "0";
        if (n == 1) {
            log.write("1 1\n");
            log.write("0\n");
            log.write("1 1\n");
            log.write("0\n");
            log.flush();
            return;
        }


        log.write(1 + " " + n + "\n");
        for (int i = 1; i <= n; i++) {
            log.write("" + (-Long.parseLong(a[i - 1]) * (long) n));
            if (i < n)
                log.write(" ");
            else
                log.write("\n");
        }

        log.write(2 + " " + n + "\n");
        for (int i = 2; i <= n; i++) {
            log.write("" + (Long.parseLong(a[i - 1]) * (long)(n - 1)));
            if (i < n)
                log.write(" ");
            else
                log.write("\n");
        }
        log.flush();

//        }
    }
}