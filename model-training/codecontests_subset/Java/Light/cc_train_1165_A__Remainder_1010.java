import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        String a = in.next();
        int count = 0;

        for (int i = n - x; i < n; i++) {
            int c = a.charAt(i) - 48;
            if (i == n - 1 - y) {
                if (c == 0) {
                    count++;
                }
                continue;
            }
            if (c == 1) {
                count++;
            }
        }


        System.out.println(count);
    }

}
