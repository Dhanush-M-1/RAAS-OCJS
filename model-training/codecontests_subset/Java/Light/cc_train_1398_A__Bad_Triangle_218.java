import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int f = 0; f < t; f++) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            for (int i = 2; i < n-1; i++)
                in.nextInt();
            int c = in.nextInt();
            if(a+b<=c)
                System.out.println("1 2 " + n);
            else
                System.out.println(-1);
        }
    }
}
