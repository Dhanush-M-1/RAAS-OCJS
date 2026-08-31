import java.util.Scanner;

public class Task236C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long res = 0;

        if (n < 3)
            res = n;
        else if ((n & 1)  == 1)
            res = n * (n-1) * (n-2);
        else if (n % 3 == 0)
            res = (n-1) * (n-2) * (n-3);
        else
            res = n * (n-1) * (n-3);
        System.out.println(res);
    }
}