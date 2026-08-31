import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bulbs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        boolean [] arr = new boolean[m];
        for (int i = 0; i < n; i++) {
            StringTokenizer lineTok = new StringTokenizer(scanner.nextLine());
            int r = Integer.parseInt(lineTok.nextToken());
            for (int j = 0; j < r; j++) {
                int i1 = Integer.parseInt(lineTok.nextToken());
                arr[i1 - 1] = true;
            }
        }

        boolean allMatch = true;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                allMatch = false;
            }
        }

        System.out.println(allMatch ? "YES" : "NO");

    }
}
