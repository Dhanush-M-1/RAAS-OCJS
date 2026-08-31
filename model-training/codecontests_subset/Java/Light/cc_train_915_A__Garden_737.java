import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int hours = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a_i = scanner.nextInt();
            if ((k % a_i == 0) && (k / a_i < hours)) {
                hours = k / a_i;
            }
        }
        System.out.println(hours);
    }
}
