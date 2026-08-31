import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a,b;

        a = in.nextInt();
        b = in.nextInt();

        int k = Math.max(a,b) - Math.min(a,b);

        int m1 = k/2;
        int m2 = k-m1;

        int result = 0;

        for(int i = 1;i<=m1;i++){
            result+=i;
        }
        for(int i = 1;i<=m2;i++){
            result+=i;
        }

        System.out.println(result);
    }
}
