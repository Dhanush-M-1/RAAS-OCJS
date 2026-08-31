import java.util.*;

public class Main{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a [] = new int[n];
        int odd=0;
        int even =0;
        for(int i=0 ;i<n ;i++)
        {
            a[i]=scan.nextInt();
            if(a[i]%2==0)
                even++;
            else
                odd++;
        }
        if(Math.abs(odd-even)<=1)
            System.out.println(0);
        else{
            int sum=0;
            Arrays.sort(a);
            if(odd > even)
            {
                int x = odd-even-1;
                for(int i=0;i<n && x>0 ;i++)
                {
                    if(a[i]%2!=0)
                    {
                        sum += a[i];
                        x--;
                    }
                        
                }
            }
            else
            {
                int x = even-odd-1;
                for(int i=0;i<n && x>0 ;i++)
                {
                    if(a[i]%2==0)
                    {
                        sum += a[i];
                        x--;
                    }
                        
                }
            }
            System.out.println(sum);
        }    
        
    }
}