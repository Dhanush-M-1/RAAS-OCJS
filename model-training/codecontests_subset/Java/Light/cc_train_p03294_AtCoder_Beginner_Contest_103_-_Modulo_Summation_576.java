import java.util.Scanner;

//C - Modulo Summation
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++) ans += sc.nextInt();
        System.out.println(ans - n);
        sc.close();
    }
}
