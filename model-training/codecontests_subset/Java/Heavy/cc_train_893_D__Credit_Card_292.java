import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int answer = 0;
        long min = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a == 0) {
                if ((min < 0) && (max >= 0)) {
                    min = 0;
                } else if ((min < 0) && (max < 0)) {
                    answer ++;
                    min = 0;
                    max = m;
                } else if (min > m){
                    System.out.print(-1);
                    System.exit(0);
                }
            } else {
                min = min + a;
                max = max + a;
                if (min > m) {
                    System.out.print(-1);
                    System.exit(0);
                }
                if (max > m) {
                    max = m;
                }

            }
        }
        System.out.print(answer);
    }

}
