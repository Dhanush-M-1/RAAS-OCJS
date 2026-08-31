import java.util.Scanner;


public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ans = (y*n) / 100-x;
        if (y*n % 100 != 0)
            ans++;
        ans = Math.max(ans, 0);
        System.out.println(ans);
    }
}
