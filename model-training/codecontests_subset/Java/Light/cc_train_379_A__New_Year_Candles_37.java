import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int a = in.nextInt();
        int b = in.nextInt();

        int good = a;
        int bad = 0;
        int ans = 0;

        while (good > 0 || bad >= b) {
            ans += good;
            bad += good;
            good = bad / b;
            bad %= b;
        }
        out.println(ans);
        out.flush();
    }
}

