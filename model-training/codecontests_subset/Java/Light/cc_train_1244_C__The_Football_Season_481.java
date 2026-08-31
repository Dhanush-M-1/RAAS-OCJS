import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.function.*;
import java.util.function.Predicate;
import java.math.BigInteger;
import java.sql.Array;
import java.time.Instant;
import java.time.Duration;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /////////////////////////////////////////////////////
        long n = sc.nextLong();
        long p = sc.nextLong();
        long w = sc.nextLong();
        long d = sc.nextLong();
        long x = -1;
        long y = -1;
        long z = -1;
        for (int i = 0; i < w; i++) {
            // i will be the num draws we are testing
            if ((p - i * d) % w == 0 && ((p - i * d) / w) + i <= n) {
                x = (p - i * d) / w;
                y = i;
                z = n - x - y;
                break;
            }
        }
        if (x < 0 || y < 0 || z < 0) {
            System.out.println("-1");
        } else {
            System.out.println(x + " " + y + " " + z);
        }
        /////////////////////////////////////////////////////
        sc.close();
    }
}