import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] str = scanner.nextLine().split(" ");
        final int n = Integer.parseInt(str[0]);
        final int m = Integer.parseInt(str[1]);

        final int[] breaks = new int[m];
        for (int i = 0; i < m; i++) {
            breaks[i] = Integer.parseInt(scanner.nextLine());
        }

        final Long[] counts = new Long[n];
        for (int i = 0; i < breaks.length; i++) {
            counts[breaks[i] - 1] = 0L;
        }

        if (counts[0] == null) counts[0] = 1L;
        if (counts.length == 1) {
            System.out.println(counts[0]);
            return;
        }

        if (counts[1] == null) counts[1] = 1L + counts[0];
        for (int i = 2; i < counts.length; i++) {
            if (counts[i] != null) continue;
            counts[i] = (counts[i - 1] + counts[i - 2]) % 1000000007L;
        }

        System.out.println(counts[counts.length - 1]);

    }
}