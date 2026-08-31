import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int s = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n ; i++) array[i] = scan.nextInt();

        Arrays.sort(array);

        long res = Math.abs(array[n / 2] - s);
        for (int i = n / 2 - 1; i >= 0; i--) {
            if (array[i] < s) break;
            res += array[i] - s;
        }

        for (int i = n / 2 + 1; i < n; i++) {
            if (array[i] > s) break;
            res += s - array[i];
        }

        System.out.println(res);

    }
}