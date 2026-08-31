import java.util.*;
public class Soln
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int amount=s.nextInt();
        int arr[]=new int[n];
        int profit=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            if((arr[i]-arr[i+1]-amount)>profit)
            profit=(arr[i]-arr[i+1])-amount;
            
        }
        System.out.print(profit);
    }
}