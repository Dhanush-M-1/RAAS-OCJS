import java.util.Scanner;

public class Main
{
    private int[] price;
    public static void main(String[] args) {
        new Main();
    }

    public Main()
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        price = new int[n];
        int flag = 0;
        int differ = 0;
        for(int  i = 0; i < n; i++)
        {
            price[i] = sc.nextInt();
        }
        for(int i = 0; i < n - 1; i++)
        {
            if(abs(price[i] - price[i + 1]) > differ)
            {
                differ = abs(price[i] - price[i + 1]);
                flag = i;
            }
        }
        if(differ - c > 0)
        {
            System.out.println(differ - c);
        }
        else System.out.println(0);

        sc.close();
    }
    
    private int abs(int a)
    {
        return a;
        /*if(a > a - (2 * a))
        {
            return a;
        }
        else return a - ( 2 * a );*/
    }
}