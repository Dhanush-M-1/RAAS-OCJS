
import java.util.*;
import java.io.*;
import java.math.*;

public class Practica_1 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 100) {
                a++;
            } else {
                b++;
            }
        }
        String rpta = "YES";
        if ((b & 1) > 0) {
            a -= 2;
            if (a < 0) {
                rpta = "NO";
            }
        }
        if ((a & 1) != 0) {
            rpta = "NO";
        }
        System.out.println(rpta);
    }

    static void pr(Object... ob) {
        System.out.println(Arrays.deepToString(ob).replace("],", " ],\n"));
    }
}
