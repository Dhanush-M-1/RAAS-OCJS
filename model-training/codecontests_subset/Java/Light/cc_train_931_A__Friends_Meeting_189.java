import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = Math.abs(a - b) / 2;
        int res = n * (n + 1);
        if (Math.abs(a - b) % 2 == 1) {
            res += n + 1;
        }
        System.out.println(res);
    }
}
