import java.util.*;

public class KitaharaGift433A
{
    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        // System.out.println("Enter number of apples");
        int n = sc.nextInt();

        int onecount = 0;
        int twocount = 0;

        for (int i=0; i<n; i++)
        {  
            // System.out.println("Enter next weight");
            int x = sc.nextInt();
            if (x==100)
            {
                onecount++;
            }
            else
            {
                twocount++;
            }
        }
        
        if (onecount % 2 == 1)
        {
            System.out.println("NO");
        }
        else if (onecount % 2 == 0 && twocount % 2 == 0)
        {
            System.out.println("YES");
        }
        else if (onecount == 0 && twocount % 2 == 1)
        {
            System.out.println("NO");
        }
        else
        {
            System.out.println("YES");
        }
    }
}
        
        
