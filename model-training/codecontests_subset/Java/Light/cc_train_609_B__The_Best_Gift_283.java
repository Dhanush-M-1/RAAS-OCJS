import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HelloWorld {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] data = scanner.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        String[] arr = scanner.nextLine().split(" ");
        int[] books = new int[n];
        int[] gen = new int[m];
        Arrays.fill(gen, 0);

        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(arr[i]);
            gen[tmp - 1] += 1;
        }

        int count = 0;
        for(int i = 0; i < m - 1; i++) {
            for(int j = i + 1; j < m; j++) {
                count += gen[i]*gen[j];
            }
        }

        System.out.println(count);

        scanner.close();
    }
}