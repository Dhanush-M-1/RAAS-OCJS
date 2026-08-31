import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), count = 0;
        int h[] = new int[100];
        int g[] = new int[100];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if (j == 0)
                {
                    h[i] = input.nextInt();
                }
                else
                {
                    g[i] = input.nextInt();
                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (h[i] == g[j])
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}