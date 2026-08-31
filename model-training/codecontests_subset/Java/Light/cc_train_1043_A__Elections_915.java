import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a, max = Integer.MIN_VALUE;
        int sum = 0;
        for (byte i = 0; i < n; i++){
            a = in.nextInt();
            sum += a;
            if (max < a)
                max = a;
        }
        while (sum >= (n*max - sum)) {
            max++;
        }

        System.out.println(max);
    }
}
