import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int remainder = 0;
        int total = a;
        while (a >= b) {
            remainder += remain(a , b);
            total += a/b;
            a = a/b + remainder;
            remainder = 0;
        }
        System.out.println(total);
    }

    public static int remain(int a , int b) {
        int total = a/b;
        return a - total*b;
    }
}
