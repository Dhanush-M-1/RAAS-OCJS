import java.util.Scanner;


public class CF168A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x = sc.nextInt();
        double y = sc.nextInt();
        int ans = (int) Math.ceil(n*y/100-x);
        System.out.println(ans > 0 ? ans : 0);
    }

}
