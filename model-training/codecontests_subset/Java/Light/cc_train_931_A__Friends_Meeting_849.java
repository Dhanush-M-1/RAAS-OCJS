import java.util.Scanner;

public class CF1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int delta = Math.abs(a - b);
        int c = delta / 2;
        if(delta % 2 == 0)
            System.out.println(2 * sum(c));
        else
            System.out.println(2 * sum(c) + c + 1);

    }

    private static int sum(int c) {
        int sum = 0;
        for(int i = 1; i <= c; i++)
            sum += i;
        return sum;
    }

}
