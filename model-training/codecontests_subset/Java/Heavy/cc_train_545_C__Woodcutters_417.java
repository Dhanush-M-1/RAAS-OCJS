import java.util.Scanner;

public class Lakadhara {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if(n == 1) {
            System.out.println(1);
            return;
        }

        Long[][] detail = new Long[n][2];

        for (int i = 0; i < n; i++) {
            detail[i][0] = scanner.nextLong();
            detail[i][1] = scanner.nextLong();

        }

        int count = 2;

        for (int i = 1; i < n - 1; i++) {
            if(detail[i][0] - detail[i - 1][0] > detail[i][1]) {
                count++;
            } else if(detail[i + 1][0] - detail[i][0] > detail[i][1]) {
                count++;
                detail[i][0] += detail[i][1];
            }
        }

        System.out.println(count);
    }
}
