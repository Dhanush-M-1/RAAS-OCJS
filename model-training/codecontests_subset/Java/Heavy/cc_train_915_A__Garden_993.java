import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if (m % x == 0 && x > max) {
                max = x;
            }

        }

        System.out.println(m / max);

    }

}