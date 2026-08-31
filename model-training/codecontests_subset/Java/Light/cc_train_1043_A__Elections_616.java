import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        int sum = 0;
        int next = 0;

        for (int i = 0; i < n; i++) {
            next = scanner.nextInt();
            max = Math.max(max, next);
            sum = sum + next;
        }

        System.out.println((int) Math.max(max, Math.floor(2 * sum / n) + 1));


    }


}


