import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        if (Math.abs(n - m) % 2 == 0) {
            int x = Math.abs(n - m) / 2;
            System.out.println(x * (x + 1));
        } else {
            int x = Math.abs(n - m) / 2;
            System.out.println(x * (x + 1) + x + 1);
        }

        out.close();
    }
}