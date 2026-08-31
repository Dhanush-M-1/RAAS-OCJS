import java.util.Scanner;

public class MainA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String line = scanner.nextLine();

        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[n];
        }

        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == '*') {
                for (int j = 1; i - j >= 0; j++) {
                    if (line.charAt(i - j) == '*') {
                        arr[i][j] = arr[i - j][j] + 1;
                    }
                }
            }
        }

        boolean result = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 4) {
                    result = true;
                    break;
                }
            }
        }

        System.out.println(result ? "yes" : "no");
    }
}
