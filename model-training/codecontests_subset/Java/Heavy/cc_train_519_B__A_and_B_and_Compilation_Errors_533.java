import java.util.Scanner;
import java.util.Arrays;

public class Chili519B
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] error1 = new int[n];
        int[] error2 = new int[n-1];
        int[] error3 = new int[n-2];
        int counter1 = 0;
        int counter2 = 0;
        
        for(int i = 0; i < n; i++)
        {
            error1[i] = scan.nextInt();
        }
        for(int i = 0; i < n-1; i++)
        {
            error2[i] = scan.nextInt();
        }
        for(int i = 0; i < n-2; i++)
        {
            error3[i] = scan.nextInt();
        }
        
        Arrays.sort(error1);
        Arrays.sort(error2);
        Arrays.sort(error3);
        
        for(int i = 0; i < n-1; i++)
        {
            if(error1[i] != error2[i])
            {
                System.out.println(error1[i]);
                counter1--;
                break;
            }
            counter1++;
        }
        if (counter1 == n-1)
            System.out.println(error1[n-1]);
        
        for(int i = 0; i < n-2; i++)
        {
            if(error2[i] != error3[i])
            {
                System.out.println(error2[i]);
                counter2--;
                break;
            }
            counter2++;
        }
        if (counter2 == n-2)
            System.out.println(error2[n-2]);
    }
}