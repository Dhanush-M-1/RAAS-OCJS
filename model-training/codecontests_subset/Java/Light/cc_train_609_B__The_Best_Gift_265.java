import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            list.add(0);
        }
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.set(value, list.get(value) + 1);
        }

        long result = ((long)n * ((long)n - 1)) / 2;
        for (int tmp :
                list) {
            result -= ((long)tmp * ((long)tmp - 1)) / 2;
        }
        System.out.print(result);
    }}