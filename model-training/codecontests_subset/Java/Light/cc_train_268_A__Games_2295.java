import java.util.Scanner;

public class same
{
    public static void main(String[] a)
    {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int [] homes = new int[n];
        int[] gest = new int[n];
        for(int i = 0; i < n; i++)
        {
            homes[i] = scan.nextInt();
            gest[i] = scan.nextInt();
        }
        int res =0;
        for(int i = 0; i < n; i++)
            for(int j =0 ; j < n; j++)
                if(i != j)
                {
                    if(homes[i] == gest[j])
                        res++;

                }
        System.out.println(res);
    }
}
