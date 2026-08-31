import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String s = scanner.next();
        int eightCount = 0;
        for (int i = 0; i < n; i++) {
            if ((int) s.charAt(i) - 48 == 8)
                eightCount++;
        }

        System.out.println(Math.min(eightCount,n/11));
    }
}
