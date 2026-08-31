
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[] a = new boolean[1000001];

        for (int i = 1; i <= n; i++)
        {
            a[scanner.nextInt()] = true;
        }

        int i = 1, j = 1000000;
        int prizeCount = 0;
        int time = -1;

        while (prizeCount < n)
        {
            if (a[i])
            {
                prizeCount++;
            }
            if (a[j])
            {
                prizeCount++;
            }
            if (a[i] && a[j] && i == j)
            {
                prizeCount--;
            }
            i++;
            j--;
            time++;
        }

        System.out.println(time);
        scanner.close();
    }
}
