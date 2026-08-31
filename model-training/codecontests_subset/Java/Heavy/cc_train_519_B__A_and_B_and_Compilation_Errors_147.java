import java.util.Arrays;
import java.util.Scanner;

public class StupidCompilationError {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Long[] first = new Long[n];
        Long[] second = new Long[n - 1];
        Long[] third = new Long[n - 2];

        for (int i = 0; i < n; i++) first[i] = scanner.nextLong();
        for (int i = 0; i < n - 1; i++) second[i] = scanner.nextLong();
        for (int i = 0; i < n - 2; i++) third[i] = scanner.nextLong();

        Arrays.sort(first);
        Arrays.sort(second);
        Arrays.sort(third);

        int ans = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if(!first[i].equals(second[i])){
                ans = i;
                break;
            }
        }

        System.out.println(first[ans]);

        ans = n - 2;

        for (int i = 0; i < n - 2; i++) {
            if(!second[i].equals(third[i])){
                ans = i;
                break;
            }
        }

        System.out.println(second[ans]);
    }
}
