import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int count = 0;

        long left_occ = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                left_occ = arr[0][0];
                count++;
                continue;
            }

            long point = arr[i][0];
            long height = arr[i][1];

            if (point - height > left_occ) {
                left_occ = point;
                count++;
                continue;
            }

            long next_point = arr[i + 1][0];

            if (next_point > point + height) {
                left_occ = point + height;
                count++;
                continue;
            }

            left_occ = point;

        }

        sb.append(count).append("\n");

        System.out.print(sb);
    }
}
