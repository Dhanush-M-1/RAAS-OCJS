import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Scanner;

public class Singleton_Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n= sc.nextInt();
            if (n%3==0)
                System.out.println(a);
            if (n%3==1)
                System.out.println(b);
            if (n%3==2)
                System.out.println(a^b);
        }

    }
}
