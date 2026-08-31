import java.util.Scanner;

public class CodeForces2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int a3 = in.nextInt();
        int a4 = in.nextInt();
        int a5 = in.nextInt();
        int sum = (a1 + a2 + a3 + a4 + a5);
        if (sum > 0 && sum % 5 == 0) {
            System.out.println(sum / 5);
        } else {
            System.out.println(-1);
        }

    }
}
