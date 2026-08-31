import java.util.Scanner;

public class A {


    public static void main(String[] args)
    {
        Scanner inp =new Scanner(System.in);

        int a = inp.nextInt();
        int b = inp.nextInt();

        int n = java.lang.Math.abs(( b - a ));

        int sum = 0;

        int m = n/2;

        sum = sum + (m*(m+1))/2;
        m = n - m;
        sum = sum + (m*(m+1))/2;

        System.out.println( sum );
    }
}
