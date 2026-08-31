import java.util.Scanner;

public class GameOfRobots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        long i = 1;
        while (true) {
            long result = (i * (i + 1)) / 2;
            if (result >= k) {
                break;
            }
            i++;
        }

        long base = (i * (i - 1)) / 2;
        int result = (int) (k - base);
        System.out.println(arr[result - 1]);
    }
}
