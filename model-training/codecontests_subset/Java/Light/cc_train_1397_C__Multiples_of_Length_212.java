import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sb.append("1 1").append("\n");
        sb.append(-arr[0]).append("\n");
        arr[0] = 0;

        if (n == 1) {
            sb.append("1 1").append("\n");
            sb.append("0").append("\n");
            sb.append("1 1").append("\n");
            sb.append("0").append("\n");

            System.out.print(sb);
            return;
        }

        sb.append("2 " + n).append("\n");

        for (int i = 1; i < n; i++) {
            long mod = arr[i] % n;

            if (mod == 0) {
                sb.append("0 ");
            } else {
                long toAdd = (n - 1) * mod;
                arr[i] += toAdd;
                sb.append(toAdd).append(" ");
            }
        }
        sb.append("\n");

        sb.append("1 " + n).append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(-arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}