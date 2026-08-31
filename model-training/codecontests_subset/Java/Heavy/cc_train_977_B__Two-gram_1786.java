import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        int[] a = new int[676];

        for (int i = 0; i < 676; i++)
        {
            a[i] = 0;
        }

        for (int i = 0; i < s.length() - 1; i++)
        {
            int first = (s.charAt(i) - 'A');
            int second = s.charAt(i + 1) - 'A';

            a[first * 26 + second]++;
        }

        int max = 0;
        int ind = 0;

        for (int i = 0; i < 676; i++)
        {
            if (max < a[i])
            {
                max = a[i];
                ind = i;
            }
        }

        char first = (char) (ind / 26 + 'A');
        char second = (char) (ind % 26 + 'A');

        System.out.print(first);
        System.out.print(second);
    }
}