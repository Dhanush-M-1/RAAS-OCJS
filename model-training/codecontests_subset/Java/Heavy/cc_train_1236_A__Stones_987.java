import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLines = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numLines; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(calc(a, b, c));
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static int calc(int a, int b, int c) {
        int count = 0;
        while (b >= 1 && c >= 2) {
            count += 3;
            b--;
            c -= 2;
        }
        while (a >= 1 && b >= 2) {
            count += 3;
            a--;
            b -= 2;
        }
        return count;
    }
}
