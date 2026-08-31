import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int req = (int) Math.ceil((y / 100.0) * n);
        System.out.println(Math.max(0, req - x));
    }
}
