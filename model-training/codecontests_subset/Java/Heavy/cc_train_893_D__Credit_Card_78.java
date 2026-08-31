import java.util.*;

public class Solution
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int arr[] = new int[n];
        int sum = 0 , count = 0;
        boolean flag = true;
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
            sum += arr[i];
            
            if(sum > d)
            {
            flag = false;
            break;
            }
            
           if(arr[i] == 0)
           {
               if(sum < 0)
               sum = 0;
           }
        }
        
        if(!flag)
        System.out.println(-1);
        
        else
        {
            sum = 0;
            for(int i = 0 ; i < n ; i++)
            {
                sum += arr[i];
                 if(sum > d)
                    sum = d;
                if(arr[i] == 0)
                {
                    if(sum <0)
                    {
                    count++;
                    sum = d;
                    }
                    
                   
                }
            }
            System.out.println(count);
        }
    }
}