import java.util.*;

public class Bear
{
    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        // System.out.println("Enter n");
        int n = sc.nextInt();
        // System.out.println("Enter c");
        int c = sc.nextInt();
        
        int answer = Integer.MIN_VALUE;
        
        // System.out.println("Enter next price");
        int pricefirst = sc.nextInt();

        for (int i=0; i<n-1; i++)
        {
            // System.out.println("Enter next price");
            int pricenext = sc.nextInt();
            int profit = pricefirst - pricenext - c;
            if (profit > answer)
            {
                answer = profit;
            }
            pricefirst = pricenext;
        }
        if (answer > 0)
           System.out.println(answer);
        else
           System.out.println(0);
    }
}
        