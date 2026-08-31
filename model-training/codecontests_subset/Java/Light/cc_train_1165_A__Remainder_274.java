import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int count = 0;

        int u = y + 1;

        if (s.charAt(n - u) == '1') {
        } else {
            count++;
        }

        for (int i = n - x; i < n - u; i++) {
            if (s.charAt(i) == '0') {
            } else {
                count++;
            }
        }
        for (int i = n - 1; i > n - u; i--) {
            if (s.charAt(i) == '0') {
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
