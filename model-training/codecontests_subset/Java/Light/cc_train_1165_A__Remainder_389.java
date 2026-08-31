import java.util.Scanner;

public class A1165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine();
        int operations = 0;
        char[] number = scanner.nextLine().toCharArray();
        for (int i = n - x ; i < n ; i++) {
            if (i == n - y - 1) {
                if (number[i] == '0')
                    operations++;
            }else{
                if (number[i] == '1')
                    operations++;
            }
        }
        System.out.println(operations);
    }
}
