import java.util.*;
import java.lang.*;
import java.io.*;

public class Candles {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int x = a;
        int r;
        while (a / b > 0) {
            if (a % b != 0) {
                x -= a % b;
                r = a % b;
            } else {
                r = 0;
            }
            a = a / b + r;
            x += a;
        }
        System.out.println(x);
    }
}