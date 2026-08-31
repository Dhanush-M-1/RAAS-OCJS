import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        System.out.println("? 0 0");
        System.out.flush();
        int flag = sc.nextInt();
        for (int i = 29; i >= 0; i--) {
            System.out.println(String.format("? %d %d", 1 << i ^ a, 1 << i ^ b));
            System.out.flush();
            int temp = sc.nextInt();
            if (flag != 0 && flag + temp == 0) {
                if (flag > 0) {
                    a |= 1 << i;
                } else {
                    b |= 1 << i;
                }
                System.out.println(String.format("? %d %d", a, b));
                System.out.flush();
                flag = sc.nextInt();
            }
            else {
                System.out.println(String.format("? %d %d", 1 << i ^ a, b));
                System.out.flush();
                temp = sc.nextInt();

                if (temp < 0) {
                    a |= 1 << i;
                    b |= 1 << i;
                } else {

                }
            }
        }
        System.out.println(String.format("! %d %d", a, b));
        System.out.flush();
        sc.close();
    }
}