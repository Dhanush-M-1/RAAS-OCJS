
import java.io.*;
import java.util.*;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        candles();
    }

    static void candles() {
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a;
        int r = 0;
        while (a > r) {
            r = a % b;
            a /= b;
            sum += a;
            a += r;
        }

        System.out.println(sum);
    }
}